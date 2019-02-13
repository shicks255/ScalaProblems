package Fundamentals.OptionForLoops.LoginProgram

case class UserInput() extends Monad [String, UserInput]{
  override def map(f: String => String): UserInput = ???
  override def flatMap(f: String => UserInput): UserInput = ???
}
