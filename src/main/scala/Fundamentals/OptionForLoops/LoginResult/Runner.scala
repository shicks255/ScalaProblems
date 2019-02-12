package Fundamentals.OptionForLoops.LoginResult

import scala.collection.mutable.ArrayBuffer

object Runner extends App{

  trait User {
  }

  case class RegularUser(userName: String, password: String) extends User {
  }
  case class Admin(userName: String, password: String, id: Long, adminCode: Long) extends User {
  }

  case class LoginResult(user: RegularUser, result: List[String]) {
    def map(f: RegularUser => RegularUser) = {
      val newUser: RegularUser = f(user)
      LoginResult(newUser, result)
    }

    def flatMap(f: RegularUser => LoginResult): LoginResult = {
      val newUser: LoginResult = f(user)
      LoginResult(newUser.user, newUser.result ::: result)
    }

    override def toString: String = {
      val st = user.toString
      val st1 = for {
        a <- result.zipWithIndex
      } yield a._2 + " " + a._1

      st + st1
    }
  }
  val users: ArrayBuffer[RegularUser] = ArrayBuffer[RegularUser]()

  val user: RegularUser = RegularUser("shicks", "ashley")
  println(user)

  val verifiedUser = for {
    a <- userNameNotDuplicate(user)
    b <- userNameLongEnough(a)
    c <- passwordLongEnough(b)
  } yield c
  println(verifiedUser)


  def userNameNotDuplicate(x: RegularUser): LoginResult = {
    users.contains(x) match {
      case false => LoginResult(x, List("Username is valid"))
      case true => LoginResult(x, List("Username INVALID"))
    }
  }
  def userNameLongEnough(x: RegularUser): LoginResult = {
    x.userName.length match {
      case y if y > 5 => LoginResult(x, List("Username is long enough"))
      case _ => LoginResult(x, List("Username is not long enough"))
    }
  }
  def passwordLongEnough(x: RegularUser): LoginResult = {
    x.password.length match {
      case y if y > 5 => LoginResult(x, List("Password is long enough"))
      case _ => LoginResult(x, List("Password is not long enough"))
    }
  }

}
