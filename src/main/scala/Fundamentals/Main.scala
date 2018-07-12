package Fundamentals

object Main extends App{

  Utilities.printSomeStrings(1)

  Utilities.printFirstLetter("steven")
  Utilities.printLastLetter("steven")
  Utilities.printStringMultiply("steven")

}

object Utilities {

  def printSomeStrings(number: Int) = {
    println(10 min 15)
  }

  def printFirstLetter(word: String) = {
    println(word.head)
    println(word.take(1)) //another way to do it
  }

  def printLastLetter(word: String) = {
//    println(word(word.length - 1))
    //better way to do it
    println(word.takeRight(1))
  }

  def printStringMultiply(word: String) = {
    println(word * 3)
  }

}
