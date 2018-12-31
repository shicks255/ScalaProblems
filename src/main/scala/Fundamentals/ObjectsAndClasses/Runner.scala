package Fundamentals.ObjectsAndClasses

object Runner {
  def main(args: Array[String]) = {
    val boo = new Cat("Boo Cat", 11)
    Cat.adoptACat(boo)

    val cruiser = new Cat("Cruiser", 12)
    Cat.adoptACat(cruiser)

    Cat.printAdoptedCats()
  }
}
