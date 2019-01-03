package Euler.Problem5

import scala.annotation.tailrec

//https://projecteuler.net/problem=5


//Smallest multiple
//Problem 5
//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

object Solution extends App{

  print(runSolution(20))

  def runSolution(upToNumber: Int): Int = {

    val divisors = List.range(1,upToNumber+1)
    var answer = getAnswer(divisors.max, divisors)

    answer
  }

  @tailrec
  def getAnswer(current: Int, divisors: List[Int]): Int = {
    val cleanDivide = divisors.filter(x => current % x == 0)
    if (cleanDivide.size == divisors.size)
      current
    else
      getAnswer(current+divisors.max, divisors)
  }
}
