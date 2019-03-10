package Fundamentals.implicits.TypeClass

import Fundamentals.TypeClasses.Speaker
import Speakable.speakingParrot
import SpeakerAPI._

object Runner extends App{
  val p = Parrot
//  p.speak
}

case class Dog()
case class Parrot()

trait Speakable[T] {
  def speak(t: T): String
}

object Speakable {
  implicit val speakingParrot = new Speakable[Parrot] {
    override def speak(t: Parrot): String = "POLLY WANNA CRACKA"
  }
}

object SpeakerAPI {
  implicit class SpeakingParrot[T](value: T){
    def speak(implicit s: Speakable[T]): String = {
      s.speak(value)
    }
  }
}