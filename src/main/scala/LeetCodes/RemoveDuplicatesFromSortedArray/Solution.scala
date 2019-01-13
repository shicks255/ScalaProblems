package LeetCodes.RemoveDuplicatesFromSortedArray

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Solution extends App{

  def removeDuplicates(nums: ArrayBuffer[Int]): Int = {

    removeDupes(nums, 1)

    println(nums.mkString(","))

    val answerSet = nums.toSet
    answerSet.size
  }

  @tailrec
  def removeDupes(numbers: ArrayBuffer[Int], starting: Int): Unit = {
    if (numbers(starting) == numbers(starting-1))
      {
        val swap = numbers.indexWhere(_ > numbers(starting-1))
        val temp = numbers(swap)
        numbers(swap) = numbers(starting)
        numbers(starting) = temp
      }

    if (starting == numbers.size-1)
      return
    removeDupes(numbers, starting+1)
  }

//  assert(removeDuplicates(ArrayBuffer(1,1,2)) == 2)
  assert(removeDuplicates(ArrayBuffer(0,0,1,1,1,2,2,3,3,4)) == 5)
}
