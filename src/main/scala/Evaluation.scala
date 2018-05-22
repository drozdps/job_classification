package org.template.classification

import org.apache.predictionio.controller.AverageMetric
import org.apache.predictionio.controller.EmptyEvaluationInfo
import org.apache.predictionio.controller.EngineParams
import org.apache.predictionio.controller.EngineParamsGenerator
import org.apache.predictionio.controller.Evaluation
import org.template.classification.EngineParamsList

case class Accuracy()
  extends AverageMetric[EmptyEvaluationInfo, Query, PredictedResult, ActualResult] {
  def calculate(query: Query, predicted: PredictedResult, actual: ActualResult)
  : Double = (if (predicted.apps_num == actual.apps_num) 1.0 else 0.0)
}

object AccuracyEvaluation extends Evaluation {
  // Define Engine and Metric used in Evaluation
  engineMetric = (ClassificationEngine(), new Accuracy())
}

object EngineParamsList extends EngineParamsGenerator {
  // Define list of EngineParams used in Evaluation

  // First, we define the base engine params. It specifies the appId from which
  // the data is read, and a evalK parameter is used to define the
  // cross-validation.
  private[this] val baseEP = EngineParams(
    dataSourceParams = DataSourceParams(evalK = Some(5)))

  // Second, we specify the engine params list by explicitly listing all
  // algorithm parameters. In this case, we evaluate 3 engine params, each with
  // a different algorithm params value.
  engineParamsList = Seq(
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 2, 100)))),
    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
      13, 21, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 500, "auto", "gini", 2, 100)))) ,
      baseEP.copy(algorithmParamsList = Seq(("naivebayes", AlgorithmParams(lambda = 1.0))))

//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "gini", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 2, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 4, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 8, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 16, 100)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 2, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 4, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 8, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 5, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 8, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 13, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 21, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 34, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 55, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 89, "auto", "entropy", 16, 1000)))),
//    baseEP.copy(algorithmParamsList = Seq(("randomforest", RandomForestAlgorithmParams(
//      13, 144, "auto", "entropy", 16, 1000))))
  )
}