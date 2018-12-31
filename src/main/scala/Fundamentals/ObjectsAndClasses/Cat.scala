package Fundamentals.ObjectsAndClasses

import scala.collection.mutable.ListBuffer

class Cat(name: String, age: Int) {

  def print(): String = name + " is " + age + " years old"
  override def toString(): String = {
    name + " - " + age
  }
}


object Cat {
  var adoptedCats = new ListBuffer[Cat]

  def adoptACat(cat: Cat): Unit = adoptedCats += cat
  def printAdoptedCats(): Unit = println(adoptedCats.mkString(","))
}
