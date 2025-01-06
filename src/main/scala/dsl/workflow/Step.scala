package dsl.workflow

case class Step(name: String)(action: () => Unit) extends WorkflowStep {
  override def execute(): Unit = {
    println(s"Executing step: $name")
    action()
  }
}
