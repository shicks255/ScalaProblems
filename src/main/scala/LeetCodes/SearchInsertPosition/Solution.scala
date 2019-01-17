//https://leetcode.com/problems/search-insert-position/

package LeetCodes.SearchInsertPosition

import scala.annotation.tailrec

object Solution extends App{

  def searchInsert2(nums: Array[Int], target: Int): Int = {
    var index: Int = 0
    var answer: Int = 0

    def search(x: Int): Unit = {
      if (x == target)
        answer = index
      index += 1
    }

    nums.foreach(search(_))
    answer
  }

  @tailrec
  def recursive(nums: Array[Int], target: Int, index: Int = 0): Int = {
    if (nums.isEmpty || nums.head == target || nums.head > target)
      return index
    recursive(nums.tail, target, index+1)
  }

  def searchInsert(nums: Array[Int], target: Int): Int =
  {
    recursive(nums, target)
  }

  assert(searchInsert(Array(1,3,5,6), 5) == 2)
//  assert(searchInsert(Array(1,3,5,6), 2) == 1)
//  assert(searchInsert(Array(1,3,5,6), 7) == 4)
//  assert(searchInsert(Array(1,3,5,6), 0) == 0)
//  assert(searchInsert(Array(), 0) == 0)
}
