package Fundamentals.implicits

object Runner2 {

  case class Person(age: Int)
  case class Animal(age: Int)

  implicit  val language: String = "Engligh"
  implicit def getAnotherPerson(p: Person): Animal = Animal(p.age)

  def doSomethingWithAnimal(a : Animal)(implicit lang: String) = {
    println(a + " " + lang)
  }

  def main(args: Array[String]) = {
    val person: Person = Person(25)
    doSomethingWithAnimal(person)("French")
  }


}
