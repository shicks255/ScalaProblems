package Euler.Problem6

//problem 6
//https://projecteuler.net/problem=6

object Solution extends App{

//  @tailrec
  def sumOfSquares(number: Int): Int = {
    var square: Int = number * number

    if (number == 1)
      square
    else
      square + sumOfSquares(number - 1)
  }

  def squareOfTheSum(number: Int): Int = {
    if (number == 1)
      number
    else
      number + squareOfTheSum(number-1)
  }

  val a = sumOfSquares(100)
  val b = squareOfTheSum(100)
  val c = b * b

  println((c - a).abs)


}