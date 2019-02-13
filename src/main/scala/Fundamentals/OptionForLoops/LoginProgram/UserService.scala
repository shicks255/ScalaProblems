package Fundamentals.OptionForLoops.LoginProgram


class UserService {
  var users: Set[RegularUser] = Set[RegularUser]()

  def addToUsers(u: RegularUser) = users += u
  def userExists(u: RegularUser) = users.contains(u)
}
