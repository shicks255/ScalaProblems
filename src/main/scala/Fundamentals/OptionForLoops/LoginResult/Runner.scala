package Fundamentals.OptionForLoops.LoginResult

import scala.collection.mutable.ArrayBuffer

object Runner extends App{

  trait User {
  }

  case class RegularUser(userName: String, password: String) extends User {
  }
  case class Admin(userName: String, password: String, id: Long, adminCode: Long) extends User {
  }

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
    a <- userNameNotDuplicate(Some(user))
    b <- userNameLongEnough(a)
    c <- passwordLongEnough(b)
  } yield c
  println(verifiedUser)


  def userNameNotDuplicate(x: Option[RegularUser]): LoginResult = {
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
