package Euler.Problem7

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Solution extends App{

  val currentTime: Long = System.currentTimeMillis()
  def isPrime(n: Int): Boolean = {
    var prime = true

    for (x <- List.range(2, n-1))
      if (n % x == 0)
        prime = false

    prime
  }

  val primes = new ListBuffer[Int]

  @tailrec
  def addNextPrime(n: Int): Int = {
    if (isPrime(n))
      primes += n

    if (primes.size == 10001)
      primes(10000)
    else
      addNextPrime(n+1)
  }

  println(addNextPrime(2))
  println("took " + (System.currentTimeMillis()-currentTime))
}
