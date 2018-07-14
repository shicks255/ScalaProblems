package Fundamentals

import scala.collection.mutable.ArrayBuffer

object Main extends App{
//  Utilities.printSomeStrings(1)
//  Utilities.printFirstLetter("steven")
//  Utilities.printLastLetter("steven")
//  Utilities.printStringMultiply("steven")
//  Utilities.oldEnoughToDrink(21)
//  Utilities.oldEnoughToDrink(2)
//  Utilities.advancedLoop()
//  Utilities.makeArray(10)
//  Utilities.makeArrayBuffer("Steven")
  Utilities.makeArrayWithTrim("Test")
}

object Utilities {

  //trimming arrayBuffer
  def makeArrayWithTrim(word: String) = {
    var myArray = new ArrayBuffer[String]()
    for (w <- word) myArray += w.toString

    myArray.trimEnd(1)
    println(myArray.mkString(","))
  }

// array
  def makeArray(length: Int) = {
    var myArray = new Array[Int](length)
    for (i <- 0 until length) myArray(i) = i

    println(myArray.mkString(","))
    println("hi")
  }

//  arrayBuffer with guard in the loop
  def makeArrayBuffer(word: String) = {
    var myArrayBuffer = ArrayBuffer[String]()
    for (i <- word if i.isLower) myArrayBuffer += i.toString

    println(myArrayBuffer.mkString(" - "))
  }

//  Conditional
  def oldEnoughToDrink(age: Int) =
  {
    if (age >= 21)
      println(age + " is old enough to drink.")
    else
      println(age + " is not old enough to drink")
  }

//  Loops
  def printSomeStrings(number: Int) = {
    for (i <- 1 to number)
      println("Line# " + i)
  }

  //loop with a yield ...aka for comprehension
  def loopWithYield() = {
//    for (i <- 1 to 10) yield var x

//    println(x)
  }

  //loop with 2 generators, and a guard
  def advancedLoop() = {
    for (i <- 1 to 10; j <- 1 to 2 if j > 1)
      println(10 * i + j + "")
  }

//  String Manipulation
  def printFirstLetter(word: String) = {
    println(word.head)
    println(word.take(1)) //another way to do it
  }

//  String Manipulation
  def printLastLetter(word: String) = {
//    println(word(word.length - 1))
    //better way to do it
    println(word.takeRight(1))
  }

//  Multiply string by int
  def printStringMultiply(word: String) = {
    println(word * 3)
  }

}
