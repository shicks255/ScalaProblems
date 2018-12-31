package Fundamentals

import java.io.File
import java.util.Scanner

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
//  Utilities.makeArrayWithTrim("Test")
//  Utilities.arrayEveryOther()
//  Utilities.yieldFromArray()
//  Utilities.playWithArray()
//  Utilities.makeAMap()
//  Utilities.makeMutableMap
//  Utilities.iterateOverMap
//  Utilities.sortedMap()
//  Utilities.makeTuples()
//  Utilities.zippingTuples()
//    Utilities.makeDiscountMapFromPriceMap()
//    Utilities.readFromFile
//  Utilities.getMinAndMaxPair()


  val someMap = scala.collection.mutable.Map[String, Int]()
  someMap += ("steve" -> 1)
50
  print(someMap)

  val immutableMap = Map("A" -> 1, "B" -> 2)
//  immutableMap += ("D" -> 3)
  val x = immutableMap + ("C" -> 3)
  print(x)

}

object Utilities {

  def getMinAndMaxPair() ={
    val values = Array[Int](10, 20, 12, 14, 40, 42, 55, 1, 100)
    val newValues = values.sorted

    val smallest = newValues(0)
    val biggest = newValues(newValues.length - 1)

    val pair = (newValues(0), newValues(newValues.length-1))
    println(pair)
  }

  def readFromFile = {
    val input = new Scanner(new File("readFromFile.txt"))
    var map = scala.collection.mutable.SortedMap[String, Int]()

    while (input.hasNext())
      {
        val next: String = input.next()
        if (next.length > 0)
          {
            next.replace(".", "")
            val words = next.split(" ")
            for (word <- words)
              {
                var count = map.getOrElse(word, 0)
                count += 1
                map(word) = count
              }
          }
      }

    for ((k,v) <- map)
      println(k + " occurs " + v)

  }

  def makeDiscountMapFromPriceMap(): Unit =
  {
    val itemsPricesMap = Map("Video Card" -> 149.99, "CPU" -> 199.99, "Case" -> 119.99, "Ram 16gb" -> 59.99)
    println(itemsPricesMap)

    val discount = for ((k, v) <- itemsPricesMap) yield (k, v * .9)
    println(discount)
  }

  def zippingTuples() = {
    val names = Array("Steve", "M", "Eric", "Steph")
    val ages = Array(29, 30, 30, 27)

    val zipped = names.zip(ages)
    for ((p1,p2) <- zipped)
      println(p1 + " - " + p2)
  }

  def makeTuples() = {
    var someTuple = "Steve Hicks".replace(" ", "").partition(_.isUpper)
    println(someTuple)
  }

  def sortedMap() = {
    val scores = scala.collection.mutable.SortedMap("Alice" -> 65,
      "Steve" -> 29, "Steph" -> 27, "Eric" -> 30, "M" -> 30)
    for ((k, v) <- scores)
      println(k + " is " + v + " years old")

    println("BREAK")

    val insertionOrderMap = scala.collection.mutable.LinkedHashMap("Alice" -> 65,
      "Steve" -> 29, "Steph" -> 27, "Eric" -> 30, "M" -> 30)
    for ((k, v) <- insertionOrderMap)
      println(s"${k} is ${v} years old")

    var reverse = for ((k,v) <- insertionOrderMap) yield (v, k)
    println(reverse)
  }

  def iterateOverMap = {
    var map = Map("Boo" -> "cat", "brandy" -> "dog")

    for ((k,v) <- map)
      print("The key is " + k + " and the value is " + v + "\n\r")

    val animalTypes = for (v <- map.values)
      println(v)
  }

  def makeMutableMap: Unit ={
    var map = scala.collection.mutable.Map[String, Int]()
    map("Steve") = 1
    map("Eric") = 2

    println(map)

    //adding multiple values
    map += (("kara", 2), ("Tom", 4))
    println(map)

    //removing a value
    map -= "kara"
    println(map)
  }

  def makeAMap(): Unit =
  {
    var mapp = Map("Steve" -> 1, "Bob" -> 2)
    println(mapp)

    val steveAge = mapp("Steve")
    println(steveAge)

    val eric = mapp.getOrElse("Eric", "The value doesn't exists")
    println(eric)

    //this line will produce error, because the key doesn't exist in map
//    val thisWillbeError = mapp("Eric")

//    var mapVersion2 = Map(("Steve", 3), ("Bob", 4))
//    println(mapVersion2)
  }

//  Common array and ArrayBuffer algorithms
  def playWithArray() = {
    var myArray = Array[String]("Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun")

    println(myArray.max)
    println(myArray.min)
//    val sorted = myArray.sorted(_<_)
//    println(sorted)
  }

  //yielding a new array from an array
  def yieldFromArray() = {
    var anArray = Array[String]("S", "S", "t", "t", "e", "e", "v", "v", "e", "e", "n", "n")
    val newArray = for (let <- 0 until(anArray.length, 2))
      yield anArray(let)

    print(newArray)
  }

  //traversing every other element
  def arrayEveryOther() = {
    var anArray = Array[Int](1,2,3,4,5,6,7,8,9,10)

    for (i <- 0 until (anArray.length, 3))
      println(i)
  }

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
