package Fundamentals.TraitPractice

object TraitTest extends App{
  val ipod = Mp3Player()
  ipod.play
  ipod.headPhonesPluggedIn
  ipod.stop

  println(ipod.turnOff)
}

case class Mp3Player() extends SomePlayer with MusicPlayer {
  def play: Unit = println("starting to play")
  def stop: Unit = println("stopping the player")

  override def turnOff: String = "turned off"
}

//abstract can extend trait
abstract class SomePlayer extends MusicPlayer {
  def headPhonesPluggedIn() = println("headphones were plugged in")
  def turnOff: String
}

//if a Trait has abstract, non implemented methods, they must be implemented in concrete class
trait MusicPlayer {
  def play
  def stop
}
