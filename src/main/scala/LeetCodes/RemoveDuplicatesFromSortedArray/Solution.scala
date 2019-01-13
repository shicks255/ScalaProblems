package LeetCodes.RemoveDuplicatesFromSortedArray

import scala.annotation.tailrec

object Solution extends App{

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.size == 1)
      return 1
    removeDupes(nums, 1)
    val answerSet = nums.toSet
    answerSet.size
  }

  @tailrec
  def removeDupes(numbers: Array[Int], starting: Int): Unit = {
    if (numbers(starting) <= numbers(starting-1))
      {
        val swap = numbers.indexWhere(_ > numbers(starting-1), starting)
        if (swap > 0)
          {
            val temp = numbers(swap)
            numbers(swap) = numbers(starting)
            numbers(starting) = temp
          }
      }

    if (starting == numbers.size-1)
      return
    removeDupes(numbers, starting+1)
  }

  assert(removeDuplicates(Array(1,1,2)) == 2)
  assert(removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4)) == 5)
  assert(removeDuplicates(Array(0,0,0,0,0,0,0,0,0,0,0,1)) == 2)
  assert(removeDuplicates(Array(0)) == 1)
}
