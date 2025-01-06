package dsl.workflow

trait WorkflowStep {
  def execute(): Unit
}