package Fundamentals.OptionForLoops.LoginProgram

trait Monad[A, B] {
  def map(f: A => A): B
  def flatMap(f: A => B): B
}
