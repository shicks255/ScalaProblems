//https://leetcode.com/problems/two-sum/description/

/**
  *
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  *
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
  *
  * Example:
  *
  * Given nums = [2, 7, 11, 15], target = 9,
  *
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1].
  *
  */

package LeetCodes.TwoSum

object Main extends App{

  val nums :Array[Int] = Array(2, 7, 11, 15)
  val target: Int = 9

  println(twoSum(nums, target).mkString(","))

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var answer = new Array[Int](2)
    val length: Int = nums.length

    for (x <- 0 until length; i <- 0 until length; if x != i && nums(x) + nums(i) == target)
      {
        answer(0) = x
        answer(1) = i
        return answer
      }

    answer
  }

}
