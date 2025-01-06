package dsl.workflow

case class Workflow(name: String)(steps: WorkflowStep*) {
  def run(): Unit = {
    println(s"Starting workflow: $name")
    steps.foreach(_.execute())
  }

  def filterSteps(condition: WorkflowStep => Boolean): Workflow = {
    Workflow(name)(steps.filter(condition): _*)
  }
}
