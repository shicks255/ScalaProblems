package Fundamentals.HOFPractice

object Functions {

  def veryBasicStrToInt(f: String => Int, s: String) = {
    f(s)
  }

  def curriedStrToInt(s: String)(f: String => Int) = {
    f(s)
  }

  def genericFunction[A,B](f: A => B, a: A) = {
    f(a)
  }

  def genericFunction2[A,B](f: A => B)(a: A) = {
    f(a)
  }

  def checkIfWordIsLongEnough(s: => String, f: => Int) = {
    if (s.length > f)
      println(s"$s is long enough")
    else
      println(s"$s is not long enough")
  }

  case class User(val userName: String, val password: String)
  case class AuthUser(val userName: String, val password: String)
  def checkIfUserCanLogIn(user: User, t: => String, f: => String): (Option[AuthUser], String) = {
    //pretend to check against database
    user match {
      case User(x,y) if x == "shicks" && y == "ashley" => (Some(AuthUser(x, y)), t)
      case _ => (None, f)
    }
  }

}
