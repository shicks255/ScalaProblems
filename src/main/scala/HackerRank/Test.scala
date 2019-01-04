package HackerRank

import scala.collection.mutable.ListBuffer

//https://www.hackerrank.com/challenges/fp-list-replication/problem?h_r=next-challenge&h_v=zen
object Test  extends App{
  def f(num: Int, arr: List[Int]): List[Int] =
  {
    val answer = new ListBuffer[Int]()

    def printXTimes(number: Int, times: Int):Unit = {
      for (x <- List.range(0, times))
        answer += number
    }

    arr.foreach(x => printXTimes(x, num))

    answer.toList
  }

  val input = List(2,1,2,3,4,5,6,7,8,9,10)

  println(f(1, input))
}
