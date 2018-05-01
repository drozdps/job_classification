package org.template.classification

import org.apache.predictionio.controller.OptionAverageMetric
import org.apache.predictionio.controller.EmptyEvaluationInfo
import org.apache.predictionio.controller.Evaluation

case class Precision(apps_num: Double)
  extends OptionAverageMetric[EmptyEvaluationInfo, Query, PredictedResult, ActualResult] {
  override def header: String = s"Precision(apps_num = $apps_num)"

  def calculate(query: Query, predicted: PredictedResult, actual: ActualResult)
  : Option[Double] = {
    if (predicted.apps_num == apps_num) {
      if (predicted.apps_num == actual.apps_num) {
        Some(1.0)  // True positive
      } else {
        Some(0.0)  // False positive
      }
    } else {
      None  // Unrelated case for calculating precision
    }
  }
}

object PrecisionEvaluation extends Evaluation {
  engineMetric = (ClassificationEngine(), new Precision(apps_num = 1.0))
}
