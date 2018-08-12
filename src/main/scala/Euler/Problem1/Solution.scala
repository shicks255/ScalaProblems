//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23.
//
//Find the sum of all the multiples of 3 or 5 below 1000.

package Euler.Problem1

object Solution extends App{

  println(allMultiplesOfThreeAndFive(1000))

  def allMultiplesOfThreeAndFive(number: Int): Int = {

    val total = for (x <- 1 until number if x % 3 == 0 || x % 5 == 0) yield x

    val runningTotal: Int = total.sum
    runningTotal
  }

}

//166833
// 99500
// = 266333
// - 33165