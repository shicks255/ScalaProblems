package Fundamentals.DuckTyping

object Runner{

  case class Person(age: Int, name: String) {
    def toString(x:String) = "age " + age + " name " + name
  }

  def main(args: Array[String]):Unit = {
    printObject(Person(29, "Steve"))
  }

  def printObject(obj: {def toString(x:String):String}) = {
    println(obj.toString(""))
  }

}
