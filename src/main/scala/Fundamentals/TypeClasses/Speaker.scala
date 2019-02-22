package Fundamentals.TypeClasses

trait Speaker[T]{
  def speak(t: T): Unit
}

object MySpeakers {
  implicit val speakingDog = new Speaker[Dog] {
    def speak(dog: Dog): Unit = {
      println(s"the dog is ${dog.name}")
    }
  }
}

object SpeakerAPI {
  implicit class SpeakingDog[T](value: T){
    def speak(implicit x: Speaker[T]): Unit = {
      x.speak(value)
    }
  }
}

