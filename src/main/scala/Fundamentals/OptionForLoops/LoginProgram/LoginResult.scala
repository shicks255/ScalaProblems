package Fundamentals.OptionForLoops.LoginProgram

case class LoginResult(user: Option[RegularUser], result: List[String]) extends Monad[Option[RegularUser], LoginResult] {

  override def map(f: Option[RegularUser] => Option[RegularUser]) = {
    val newUser: Option[RegularUser] = f(user)
    LoginResult(newUser, result)
  }

  override def flatMap(f: Option[RegularUser] => LoginResult): LoginResult = {
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
