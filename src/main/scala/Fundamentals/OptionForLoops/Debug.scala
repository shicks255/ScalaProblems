package Fundamentals.OptionForLoops

import scala.collection.mutable.ArrayBuffer

case class User(val name: String, val password: String) {

}


object Runner extends App {

  val users: ArrayBuffer[User] = new ArrayBuffer[User]()

  val u: User = User("shicks", "ashley")

//  val u1:Option[User] = ensureUserNotExists(u)
//  val u2:Option[User] = santizeUsername(u)
//  val u3:Option[User] = sanitizePassword(u)

  val something = sanitizePassword(santizeUsername(ensureUserNotExists(u)))
  println(something)

  def ensureUserNotExists(u: User): Option[User] = {
    users.contains(u) match
    {
      case false => Some(u)
      case true => None
    }
  }

  def santizeUsername(u: Option[User]): Option[User] = {
    if (u.nonEmpty)
    {
      if (u.get.name.length > 5)
        Some(u)
      else
        None
    }
    None
  }

  def sanitizePassword(u: Option[User]): Option[User] = {
    if (u.nonEmpty)
    {
      val p = u.get.password
      val hasNumber: Boolean = p.exists(Character.isDigit(_))
      val hasUpper: Boolean = p.exists(_.isUpper)

      hasNumber && hasUpper match
      {
        case true => Some(u)
        case _ => None
      }
    }
    None
  }


}
