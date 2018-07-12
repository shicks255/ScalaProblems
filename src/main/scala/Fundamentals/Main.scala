package Fundamentals

object Main extends App{

  Utilities.printSomeStrings(1)

  Utilities.printFirstLetter("steven")
  Utilities.printLastLetter("steven")

}

object Utilities {

  def printSomeStrings(number: Int) = {
    println(10 min 15)
  }

  def printFirstLetter(word: String) = {
    println(word.head)
  }

  def printLastLetter(word: String) = {
    println(word(word.length - 1))
  }

}
