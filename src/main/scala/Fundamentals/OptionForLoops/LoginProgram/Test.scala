package Fundamentals.OptionForLoops.LoginProgram

import scala.io.StdIn.readLine

object Test extends App{

  promptUser("Enter a username").flatMap(x => getInput()).map(c => c)

  for {
    _ <- promptUser("hi")
    _ <- promptUser("hi2")
    _ <- promptUser("hi3")
    _ <- promptUser("hi4")
  } yield ()

  def promptUser(s: String): IO[Unit] = IO(println(s))
  def getInput(): IO[String] = IO(readLine())
}
