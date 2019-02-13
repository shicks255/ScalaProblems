package Fundamentals.OptionForLoops.LoginProgram

//A == String or Unit
class IO[A](constructorCodeBlock: => A) {

  def run = constructorCodeBlock

  def map[B](f: A => B): IO[B] = {
    flatMap(a => IO(f(a)))
  }

  def flatMap[B](f: A => IO[B]): IO[B] = {
    val result1: IO[B] = f(run)
    val result2: B = result1.run
    IO(result2)
  }
}

object IO{
  def apply[A](run: => A): IO[A] = new IO(run)
}
