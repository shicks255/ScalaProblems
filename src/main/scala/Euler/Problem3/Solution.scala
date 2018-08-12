//Largest Prime Factory
/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  */

package Euler.Problem3

object Solution extends App{

//  var number = BigInt(21)
  var number: Long = 600851475143l

  println(problem(number))

  def problem(number: Long): Long = {
    var coursor = number-1
    var answer: Long = 0

    while(coursor > 1)
    {
      println(coursor)
      if (number % coursor == 0)
      {
        if (isPrime(coursor))
        {
          if (coursor > answer)
            answer = coursor
        }
      }

      coursor -= 1
    }

    answer
  }


  def isPrime(number: Long): Boolean = {
    var x = 2
    while (x < (number / 2))
    {
      if (number % x == 0)
        return false
      x += 1
    }

    true
  }

}
