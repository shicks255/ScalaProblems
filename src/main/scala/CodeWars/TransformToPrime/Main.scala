//https://www.codewars.com/kata/5a946d9fba1bb5135100007c/train/scala

package CodeWars.TransformToPrime

object Main extends App{

  val test1 = Seq(1,2,3) // 1
  val test2 = Seq(5,2) // 0
  val test3 = Seq(2,12,8,4,6) // 5

  println(minumumNumber(test3))

    //Prime number is only divisible by 1 and itself
    //therefor, nothing even first of all.

  def minumumNumber(numbers: Seq[Int]): Int = {
    var currentSum = numbers.sum

    if (isPrime(currentSum))
      return 0;

    var numberToAdd = 1;
    val answer = findPrime(currentSum, numberToAdd)
    answer-currentSum
  }

  def findPrime(currentSum: Int, numberToAdd: Int): Int = {
    var newNumber = currentSum + numberToAdd;

    if (isPrime(newNumber))
      return newNumber

    if (newNumber % 2 == 0)
      findPrime(newNumber, 1)
    else
      findPrime(newNumber, 2)
  }

  def isPrime(number : Int): Boolean = {

    for (i <- 2 until number)
      {
        if (number % i == 0)
          return false;
      }
    true
  }

}
