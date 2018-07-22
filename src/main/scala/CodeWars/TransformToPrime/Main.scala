//https://www.codewars.com/kata/5a946d9fba1bb5135100007c/train/scala

package CodeWars.TransformToPrime

object Main extends App{

  val test1 = Seq(1,2,3) // 1
  val test2 = Seq(5,2) // 0
  val test3 = Seq(2,12,8,4,6) // 5

  minumumNumber(test3)

  def minumumNumber(numbers: Seq[Int]): Int = {

    //Prime number is only divisible by 1 and itself
    //therefor, nothing even first of all.

    var currentSum = numbers.sum

    println(currentSum)

    1
  }

}
