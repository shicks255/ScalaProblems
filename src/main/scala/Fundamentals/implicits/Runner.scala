package Fundamentals.implicits

object Runner extends App{

  implicit val string: String = "hola"
  def printImplicit(implicit s: String) = {
    println(s)
  }
  printImplicit
  printImplicit
  printImplicit("ahhhh")


  case class MyDouble(value: Double)
  def printAdouble(d: MyDouble) = {
    println(d)
  }

  implicit def stringToDouble(s: String): MyDouble = {
    try {
      MyDouble(s.toDouble)
    } catch {
      case e: Exception => MyDouble(0.0)
    }
  }

  printAdouble("3.5")

}
