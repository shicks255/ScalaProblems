//package Fundamentals.OptionForLoops.LoginProgram
//
//import Fundamentals.OptionForLoops.LoginProgram.AuthHelpers._
//
//import scala.annotation.tailrec
//import scala.io.StdIn.readLine
//
//object Runner extends App{
//
//  program()
//
//  @tailrec
//  def program(): Unit = {
//
//    val user: String = for {
//      _ <- promptUser("Enter a username")
//      u <- getInput()
//      _ <- promptUser("Now enter a password")
//      p <- getInput()
//    } yield RegularUser(u.toString, p.toString)
//
//    promptUser("Enter a username").flatMap(_ => getInput())
//
//
//    val result = verifyUser(user)
//
//    val response = result match {
//      case LoginResult(None, xs) => "invalid..." + xs.foldLeft("")(_ + " " + _)
//      case LoginResult(Some(x), xs) => x.userName + " added to database with password " + x.password
//    }
//    println(response)
//    println("type C to continue or Q to quit")
//
//    val input = readLine();
//    if (input == "Q")
//      System.exit(1)
//    else
//      program()
//  }
//
//  def promptUser(s: String): IO = IO(println(s))
//  def getInput(): IO = IO(readLine())
//
//
//  def verifyUser(u: RegularUser): LoginResult = {
//    val result = for {
//      a <- userNameNotDuplicate(Some(u))
//      b <- userNameLongEnough(a)
//      c <- passwordLongEnough(b)
//    } yield c
//
//    result
//  }
//
//}
