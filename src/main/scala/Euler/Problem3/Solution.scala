//Largest Prime Factory
/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  */

package Euler.Problem3

object Solution extends App{

  var number = BigInt(600851475143l)
//  var number = BigInt(600851475143l)

  println(problem(number))

  def problem(number: BigInt): BigInt = {
    var coursor = number-1
    var answer = BigInt(0)

    while(coursor > 1)
    {
      if (isPrime(coursor))
      {
        if (number % coursor == 0)
        {
          if (coursor > answer)
            answer = coursor
        }
      }

      coursor -= 1
    }

    answer
  }


  def isPrime(number: BigInt): Boolean = {
    var x = 2
    while (x < number)
    {
      if (number % x == 0)
        return false
      x += 1
    }

    true
  }

}
