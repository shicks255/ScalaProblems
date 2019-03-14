package Fundamentals.Variance

object Example2 extends App{

  trait Creature {
    def speak: String
  }
  class Animal() extends Creature {
    override def speak: String = "My Animal sound is..."
  }
  trait Feline extends Animal {
    override def speak: String = super.speak + " meow"
  }
  trait Canine extends Animal{
    override def speak: String = super.speak + " woof"
  }
  case class Dog() extends Animal with Canine {
    override def speak: String = super.speak + " I'm a dog"
  }
  case class Cat() extends Animal with Feline {
    override def speak: String = super.speak + " I'm a cat"
  }

  case class GenericCage[+A](a: A)
  case class SpecificCage[A](a: A)
  case class DogCage[A <: Canine](a: A)
  case class CatCage[A <: Feline](a: A)

  def putCatInCatCage(catCage: CatCage[Feline]) = {
    println(catCage.a.speak)
  }
  putCatInCatCage(CatCage(new Feline {}))
  putCatInCatCage(CatCage(Cat()))

  def putAnimalInSpecificCage(animal: SpecificCage[Feline]) = {
    println(animal.a.speak)
  }
  putAnimalInSpecificCage(SpecificCage(new Feline {}))
  putAnimalInSpecificCage(SpecificCage(Cat()))

  def putAnimalInGenericCage(animal: GenericCage[Animal]) = {
    println(animal.a.speak)
  }
  putAnimalInGenericCage(GenericCage(Dog()))
  putAnimalInGenericCage(GenericCage(Cat()))

//  def putAnimalInCatCage[A <: Feline](a: A) = {
//    println(a.speak)
//  }
//  putAnimalInCatCage(Cat())

}
