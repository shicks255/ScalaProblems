package Fundamentals.OptionForLoops.LoginProgram.LoginResult

import Fundamentals.OptionForLoops.LoginProgram.LoginResult.AuthHelpers._
object Runner extends App{

  case class RegularUser(userName: String, password: String)

  val u = RegularUser("shicks", "ashley")




  val verifiedUser = for {
    a <- userNameNotDuplicate(Some(u))
    b <- userNameLongEnough(a)
    c <- passwordLongEnough(b)
  } yield c
  println(verifiedUser)
}
