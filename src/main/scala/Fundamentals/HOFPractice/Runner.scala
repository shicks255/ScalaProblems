package Fundamentals.HOFPractice

import Functions._

object Runner extends App{

//  takes an annonymouse function and a string,
  //  and calls annonmyous function on string
  //
  println(veryBasicStrToInt(s => s.length, "input"))
  println(veryBasicStrToInt(s => {
    try {
      s.toInt
    }
    catch {
      case e: Exception => 0
    }
  }, "1"))

  //similar to above, but with types
  println(genericFunction[String, Int](s => s.length, "string"))
  println(genericFunction[Int, Int](i => i*2, 2))

  //similar to above, but partially applying

  val squarer = genericFunction2[Int, Int](i => i*i) _
  println(squarer(5))

  //this is a better example, because it is curried
  //so the second param set can look like a code block
  println(curriedStrToInt("input") {
    s => s.length + 1
  })

  //this is using by name, so it
  checkIfWordIsLongEnough("wordf", 4)

  val maybe: (Option[AuthUser], String) = checkIfUserCanLogIn(User("shaicks", "ashley"), "Good Login", "Bad Login")
  println(s"User ${maybe._1}  ${maybe._2}")



}
