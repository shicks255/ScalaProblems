//https://www.codewars.com/kata/mean-square-error/train/scala

//Complete the function that
//
//accepts two arrays of equal length
//  compares the value each member in one array to the corresponding member in the other
//squares the absolute value difference between those two values
//and returns the average of those squared absolute value difference between each member pair.
//solution([1,2,3], [4,5,6]) // should === 9 ((9 + 9 + 9) / 3)
//solution([10, 20, 10, 2], [10, 25, 5, -2]) // should === 16.5 ((0 + 25 + 25 + 16) / 4)
//solution([-1,0], [0,-1]) // should === 1 ((1 + 1) / 2)


package CodeWars.MeanSquareError

object Solution extends App{
  def solution(a: Array[Int], b: Array[Int]): Double = {
    val zipped = a.zip(b)

    val absoluteValues = zipped.map{
      case(x,y) => Math.abs(x - y)
    }

    val absolutesSquared = absoluteValues.map(scala.math.pow(_,2))
    absolutesSquared.foldLeft(0.0)(_+_)/a.length
  }

  def solutionCrazy(a: Array[Int], b: Array[Int]): Double = {
    a.zip(b).map{case(x,y) => Math.abs(x-y)}.map(scala.math.pow(_,2)).foldLeft(0.0)(_+_)/a.length
  }

  val tests = List(
    (Array(1, 2, 3),       Array(4, 5, 6),         9.0),
    (Array(10, 20, 10, 2), Array(10, 25, 5, -2),  16.5),
    (Array(0, -1),         Array(-1, 0),           1.0)
  )

  tests.foreach {case (first, second, answer) => assert(solutionCrazy(first, second) == answer)}
}
