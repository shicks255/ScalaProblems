package Fundamentals.TypeClasses

sealed trait Animal
case class Dog(name: String) extends Animal
case class Cat(name: String) extends Animal

object Runner extends App{
  import MySpeakers.speakingDog
  import SpeakerAPI.SpeakingDog

  val d = new Dog("brandy")
  d.speak
}
