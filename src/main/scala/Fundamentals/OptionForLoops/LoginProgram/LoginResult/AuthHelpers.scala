package Fundamentals.OptionForLoops.LoginProgram.LoginResult

import Fundamentals.OptionForLoops.LoginProgram.LoginResult.Runner.{LoginResult, RegularUser}

import scala.collection.mutable.ArrayBuffer

object AuthHelpers {

  def userNameNotDuplicate(x: Option[RegularUser], users: ArrayBuffer[RegularUser]): LoginResult = {
    if (x.nonEmpty)
    {
      users.contains(x) match {
        case false => LoginResult(x, List("Username is valid"))
        case true => LoginResult(None, List("Username INVALID"))
      }
    }
    else
      LoginResult(None, List("Username INVALID"))
  }
  def userNameLongEnough(x: Option[RegularUser]): LoginResult = {
    if (x.nonEmpty)
    {
      x.get.userName.length match {
        case y if y > 5 => LoginResult(x, List("Username is long enough"))
        case _ => LoginResult(None, List("Username is not long enough"))
      }
    }
    else
      LoginResult(None, List("Username is not long enough"))
  }
  def passwordLongEnough(x: Option[RegularUser]): LoginResult = {
    if (x.nonEmpty)
    {
      x.get.password.length match {
        case y if y > 5 => LoginResult(x, List("Password is long enough"))
        case _ => LoginResult(None, List("Password is not long enough"))
      }
    }
    else
      LoginResult(None, List("Password is not long enough"))
  }

}
