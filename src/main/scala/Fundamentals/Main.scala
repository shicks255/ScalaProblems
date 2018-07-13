package Fundamentals

object Main extends App{
  Utilities.printSomeStrings(1)
  Utilities.printFirstLetter("steven")
  Utilities.printLastLetter("steven")
  Utilities.printStringMultiply("steven")
  Utilities.oldEnoughToDrink(21)
  Utilities.oldEnoughToDrink(2)
}

object Utilities {

//  Conditional
  def oldEnoughToDrink(age: Int) =
  {
    if (age >= 21)
      println(age + " is old enough to drink.")
    else
      println(age + " is not old enough to drink")
  }

//  For Loops
  def printSomeStrings(number: Int) = {
    for (i <- 1 to number)
      println("Line# " + i)
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
