package Fundamentals.FunctionalProgrammingInScala

object Excersises {

  def main(args: Array[String]): Unit = {

    val x = curry((a: Int,b: Int) => a+b)
    val answer = x(4)(5)
    println(answer)

    val y = uncurry((a: Int) => ((b: String) => a+b.toInt))
    val answer2 = y(2,"5")
    println(answer2)

    val z = compose((a: Int) => a*2, (b: Int) => b*2)
    val answer3 = z(3)
    println(answer3)
  }

  //Excersize 2.4
  def curry[A,B,C](f: (A,B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a,b)
  }
//Excersize 2.5
  def uncurry[A,B,C](f: A => B => C): (A,B) => C = {
    (a: A, b: B) => f(a)(b)
  }
//Excersize 2.5
  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }

}
