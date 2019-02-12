package Fundamentals.Monoids

object Runner extends App{

  foldExample()
  foldExampleMultiply()
  foldAgain()
  foldMap()
  balancedFold()

  def foldExample() = {
    val nums: List[Int] = List(1,2,3,4)
    val result = nums.foldLeft(MyMonoids.intAddition.zero)(MyMonoids.intAddition.op)
    println(result)
  }

  def foldExampleMultiply() = {
    val nums: List[Int] = List(1,2,3,4)
    val result = nums.foldLeft(MyMonoids.intMultiplication.zero)(MyMonoids.intMultiplication.op)
    println(result)
  }

  def foldAgain() = {
    val strings = List("hi ", "wordld ", "how ", "are ", "you")
    val result = MyMonoids.fold(MyMonoids.stringConcat, strings)
    println(result)
  }

  def foldMap() = {
    val strings = List("1", "2", "3", "4")
    val result = MyMonoids.foldMap(MyMonoids.intMultiplication, strings){_.toInt}
    println(result)
  }

  def balancedFold() = {
    val nums = List(1,2,3,4)
    val result = MyMonoids.balancedFold(MyMonoids.intMultiplication, nums)
    println(result)
  }

}



