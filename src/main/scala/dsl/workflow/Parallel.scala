package dsl.workflow

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._

case class Parallel(steps: WorkflowStep*) extends WorkflowStep {
  override def execute(): Unit = {
    println(s"Executing parallel steps (${steps.length} steps):")
    val futures = steps.map(step => Future {
      step.execute()
    })

    Await.result(Future.sequence(futures), Duration.Inf)
    println("All parallel steps completed.")
  }
}