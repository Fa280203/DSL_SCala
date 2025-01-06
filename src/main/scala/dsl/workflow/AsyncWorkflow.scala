package dsl.workflow

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

case class AsyncWorkflow(name: String)(steps: WorkflowStep*) {
  def runAsync(): Future[Unit] = {
    println(s"Starting async workflow: $name")
    Future.sequence(steps.map(step => Future(step.execute()))).map(_ => println("Async workflow completed."))
  }
}
