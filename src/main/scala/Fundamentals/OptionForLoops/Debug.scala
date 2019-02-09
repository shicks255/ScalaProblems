package Fundamentals.OptionForLoops

import scala.collection.mutable.ArrayBuffer

case class User(val name: String, val password: String)
case class AddUserResult(val user: Option[User], val message: String) {
  def map(f: Option[User] => Option[User]): AddUserResult = {
    val newVal = f(user)
    AddUserResult(newVal, message)
  }

  def flatMap(f: Option[User] => AddUserResult): AddUserResult = {
    val newVal = f(user)
    AddUserResult(newVal.user, message + newVal.message)
  }
}

object Runner extends App {
  val users: ArrayBuffer[User] = new ArrayBuffer[User]()
  val u: User = User("shicks", "ashleY1")

  val something = for {
    a <- ensureUserNameNotExistsWithResult(u)
    b <- sanitizeUserNameWithResult(a)
    c <- sanitizePasswordWithResult(b)
  } yield c
  println(something)

//  val something = sanitizePasswordWithResult(sanitizeUserNameWithResult(ensureUserNameNotExistsWithResult(u)))
//  println(something)

  def ensureUserNameNotExistsWithResult(u: User): AddUserResult = {
    users.map(_.name).contains(u.name) match {
      case false => AddUserResult(Some(u), "Username does not exists,")
      case true => AddUserResult(None, "Username already exists,")
    }
  }

  def sanitizeUserNameWithResult(u: Option[User]): AddUserResult = {
    if (u.nonEmpty)
        u.get.name.length match {
          case x if x > 5 => AddUserResult(u, "\nUsername is valid,")
          case _ => AddUserResult(None, "Username too short,")
        }
    else
      AddUserResult(None, "Invalid username,")
  }

  def sanitizePasswordWithResult(u: Option[User]): AddUserResult = {
    if (u.nonEmpty)
      {
        val hasNumber: Boolean = u.get.password.exists(Character.isDigit(_))
        val hasUpper: Boolean = u.get.password.exists(_.isUpper)

        hasNumber && hasUpper match {
          case true => AddUserResult(u, "\nValid password,")
          case false => AddUserResult(None, "invalid password,")
        }
      }
    else
      AddUserResult(None, "Invalid password,")
  }


}
