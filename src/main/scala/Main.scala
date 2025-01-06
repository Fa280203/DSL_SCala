package dsl.workflow

import scala.concurrent.Await
import scala.concurrent.duration.Duration

@main
def main(): Unit = {
  println("Starting the workflow")

  val workflow = Workflow("Example Workflow")(
    Step("Step 1") { () => println("Step 1 completed.") },
    Step("Step 2") { () => println("Step 2 completed.") },
    Parallel(
      Step("Parallel Step 1") { () =>
        Thread.sleep(1000)
        println("Parallel Step 1 completed.")
      },
      Step("Parallel Step 2") { () =>
        Thread.sleep(2000)
        println("Parallel Step 2 completed.")
      }
    ),
    AsyncStep("Async Step", 1500) { () => println("Async Step completed.") },
    Step("Final Step") { () => println("Workflow completed!") }
  )

  workflow.run()

  println("Workflow finished")

  val asyncWorkflow = AsyncWorkflow("Example Async Workflow")(
    AsyncStep("Async Step A", 1000) { () => println("Step A done.") },
    AsyncStep("Async Step B", 2000) { () => println("Step B done.") }
  )

  Await.result(asyncWorkflow.runAsync(), Duration.Inf)
}