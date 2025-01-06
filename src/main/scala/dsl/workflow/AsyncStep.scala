package dsl.workflow

import scala.concurrent._
import ExecutionContext.Implicits.global

case class AsyncStep(name: String, delay: Int)(action: () => Unit) extends WorkflowStep {
  override def execute(): Unit = {
    Future {
      Thread.sleep(delay)
      println(s"Async Step: $name starting.")
      action()
      println(s"Async Step: $name completed.")
    }
  }
}