package Fundamentals.ObjectsAndClasses

import java.time.LocalDate

object Runner {
  def main(args: Array[String]) = {
    val boo = new Cat("Boo Cat", LocalDate.of(2007, 6, 23), "female")
    Cat.adoptACat(boo)

    val cruiser = new Cat("Cruiser", LocalDate.of(2001, 7, 15), "male")
    cruiser.dateOfDeath = LocalDate.of(2012, 10, 5)
    Cat.adoptACat(cruiser)

    Cat.printAdoptedCats()

    println("Cats still alive:")
    println(Cat.catsAlive().mkString(", "))

    println("Cats that are dead")
    println(Cat.catsDead().mkString(", "))
  }
}
