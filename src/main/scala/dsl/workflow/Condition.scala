package dsl.workflow

case class Condition(predicate: () => Boolean) {
  def isMet: Boolean = predicate()
}
