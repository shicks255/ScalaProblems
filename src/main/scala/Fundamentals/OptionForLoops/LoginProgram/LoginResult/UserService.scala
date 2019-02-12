package Fundamentals.OptionForLoops.LoginProgram.LoginResult

import Fundamentals.OptionForLoops.LoginProgram.LoginResult.Runner.RegularUser

class UserService {
  var users: Set[RegularUser] = Set[RegularUser]()

  def addToUsers(u: RegularUser) = users += u
  def userExists(u: RegularUser) = users.contains(u)
}
