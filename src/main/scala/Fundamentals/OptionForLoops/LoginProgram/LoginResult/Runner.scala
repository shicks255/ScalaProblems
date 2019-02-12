package Fundamentals.OptionForLoops.LoginProgram.LoginResult

import scala.collection.mutable.ArrayBuffer
import Fundamentals.OptionForLoops.LoginProgram.LoginResult.AuthHelpers._

object Runner extends App{

  trait User
  case class RegularUser(userName: String, password: String) extends User
  case class LoginResult(user: Option[RegularUser], result: List[String]) {
    def map(f: Option[RegularUser] => Option[RegularUser]) = {
      val newUser: Option[RegularUser] = f(user)
      LoginResult(newUser, result)
    }

    def flatMap(f: Option[RegularUser] => LoginResult): LoginResult = {
      val newUser: LoginResult = f(user)
      LoginResult(newUser.user, newUser.result ::: result)
    }

    override def toString: String = {
      val st = user match {
        case Some(x) => x.userName + " " + x.password
        case None => "err"
      }
      val st1 = for {
        a <- result.zipWithIndex
      } yield (a._2 + " " + a._1)

      st + " " + st1.foldLeft("")((i,s) => i + "-" + s)
    }
  }
  val users: ArrayBuffer[RegularUser] = ArrayBuffer[RegularUser]()
  val user: RegularUser = RegularUser("shicks", "ashley")
  println(user)

  val verifiedUser = for {
    a <- userNameNotDuplicate(Some(user), users)
    b <- userNameLongEnough(a)
    c <- passwordLongEnough(b)
  } yield c
  println(verifiedUser)




}
