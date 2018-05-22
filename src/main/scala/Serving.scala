package org.template.classification

import org.apache.predictionio.controller.LServing

class Serving extends LServing[Query, PredictedResult] {

  override
  def serve(query: Query,
    predictedResults: Seq[PredictedResult]): PredictedResult = {

    for(pr <- predictedResults) {
      println(pr)
    }

    predictedResults.head

//    val standard: Seq[Array[Double]] = predictedResults.map(_.apps_num)
//    new PredictedResult(standard.flatten.toArray)
  }
}
