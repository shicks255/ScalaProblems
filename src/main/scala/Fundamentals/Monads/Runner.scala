package Fundamentals.Monads

import scala.io.StdIn._

object Runner  extends App {
  class IO[A](c: => A) {

    def run = c

    def flatMap[B](f: A => IO[B]): IO[B] = {
      val result1: IO[B] = f(run)
      val result2:B = result1.run
      IO(result2)
    }
    def map[B](f: A => B): IO[B] = {
      flatMap(a => IO(f(a)))
    }
  }
  object IO {
    def apply[A](f: => A): IO[A] = new IO(f)
  }

  def getInput(): String = {
    val input = readLine()
    input
  }

//  val x = getInput()
//    .flatMap(() => getInput())
//      .map(() => "")
//
//  println(x)

  val answer = for {
    n <- getInput()
    b <- getInput()
  } yield n + " " + b

  println(answer)
}
