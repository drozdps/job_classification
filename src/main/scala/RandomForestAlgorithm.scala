package org.template.classification

import org.apache.predictionio.controller.P2LAlgorithm
import org.apache.predictionio.controller.Params

import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.tree.model.RandomForestModel
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.SparkContext

import grizzled.slf4j.Logger

case class RandomForestAlgorithmParams(
  numClasses: Int,
  numTrees: Int,
  featureSubsetStrategy: String,
  impurity: String,
  maxDepth: Int,
  maxBins: Int
) extends Params

// extends P2LAlgorithm because the MLlib's RandomForestAlgorithm doesn't contain RDD.
class RandomForestAlgorithm(val ap: RandomForestAlgorithmParams)
  extends P2LAlgorithm[PreparedData, RandomForestModel, Query, PredictedResult] {

  @transient lazy val logger = Logger[this.type]

  def train(sc: SparkContext, data: PreparedData): RandomForestModel = {// Empty categoricalFeaturesInfo indicates all features are continuous.
    val categoricalFeaturesInfo = Map[Int, Int](0 -> 16, 1 -> 4, 2 -> 6, 3 -> 6, 4 ->6, 5 ->3, 6->9, 7->6)
    RandomForest.trainClassifier(
      data.labeledPoints,
      ap.numClasses,
      categoricalFeaturesInfo,
      ap.numTrees,
      ap.featureSubsetStrategy,
      ap.impurity,
      ap.maxDepth,
      ap.maxBins)
  }

  def predict(model: RandomForestModel, query: Query): PredictedResult = {
    val features = Vectors.dense(
      Array(query.owner_type, query.plumbing, query.hazard, query.city_owned, query.landmarked, query.building_type, query.job_type, query.borough)
    )
    val label = model.predict(features)
    new PredictedResult(label)
  }

}
