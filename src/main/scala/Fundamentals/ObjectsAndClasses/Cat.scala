package Fundamentals.ObjectsAndClasses

import java.time.LocalDate

import scala.collection.mutable.ListBuffer

class Cat(n: String, dob: LocalDate, g: String) {
  private val name: String = n
  private val dateOfBirth: LocalDate = dob
  private val gender: String = g
  var dateOfDeath: LocalDate = null
  def print(): String = name + " is " + getAge() + " years old, and is a " + gender
  override def toString(): String = {
    name + " - " + getAge() + " : " + gender
  }

  def getAge(): Int = {
    val today = if (dateOfDeath != null) dateOfDeath else LocalDate.now()
    val age: Int = today.getYear - dob.getYear
    age
  }

  def isDead(): Boolean = dateOfDeath != null
}


object Cat {
  var adoptedCats = new ListBuffer[Cat]

  def adoptACat(cat: Cat): Unit =
  {
      adoptedCats += cat
      println(cat.name + " added to list of adopted cats")
  }
  def printAdoptedCats(): Unit = println(adoptedCats.mkString(", "))
  def catsAlive(): List[Cat] = adoptedCats.filter(p => p.isDead() == false).toList
  def catsDead(): List[Cat] = adoptedCats.filter(p => p.isDead()).toList

}
