package org.template.classification

import org.apache.predictionio.controller.EngineFactory
import org.apache.predictionio.controller.Engine

class Query(
  val owner_type : Double,
  val plumbing : Double,
  val hazard : Double,
  val city_owned : Double,
  val landmarked : Double,
  val building_type : Double,
  val job_type : Double,
  val borough : Double
) extends Serializable

class PredictedResult(
  val apps_num: Double
) extends Serializable

class ActualResult(
  val apps_num: Double
) extends Serializable

object ClassificationEngine extends EngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map(
        "randomforest"  -> classOf[RandomForestAlgorithm],
        "naivebayes"  -> classOf[NaiveBayesAlgorithm]),
      classOf[Serving])
  }
}
