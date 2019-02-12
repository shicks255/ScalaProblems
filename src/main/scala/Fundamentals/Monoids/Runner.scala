package Fundamentals.Monoids

object Runner extends App{

  foldExample()
  foldExampleMultiply()

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

}



