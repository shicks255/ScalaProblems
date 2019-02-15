package Fundamentals.OptionForLoops.LoginProgram

import scala.io.StdIn.readLine

object Test extends App{

//  promptUser("Enter a username").flatMap(x => getInput()).map(c => c)

  val d = for {
    _ <- promptUser("First Name...")
    b <- getInput()
//    _ <- promptUser("Last Name...")
//    c <- getInput()
  } yield b

  println(d.lastMsg())

  def promptUser(s: String): IO[Unit] = {
    println(s"prompting user with $s")
    val x = IO(println(s))
    println(s"got an IO as $x")
    x
  }
  def getInput(): IO[String] = {
    println("going to read some input now")
    val x = IO(readLine())
    println(s"got an IO as $x")
    x
  }
}
