//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
/**
  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
  *
  * Find the median of the two sorted arrays.
  * The overall run time complexity should be O(log (m+n)).
  *
  * You may assume nums1 and nums2 cannot be both empty.
  *
  *
  *
  * Example 1:
  *
  * nums1 = [1, 3]
  * nums2 = [2]
  *
  * The median is 2.0
  * Example 2:
  *
  * nums1 = [1, 2]
  * nums2 = [3, 4]
  *
  * The median is (2 + 3)/2 = 2.5
  */
package LeetCodes.MedianOfTwoSortedArrays

object Main extends App{

  println(findMedianSortedArrays(Array(1,2,3), Array(2,4,6)))

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {

    val nums3 = nums1 ++ nums2
    val newSeq = nums3.toSeq.sorted
    var answer: Double = 0

    if (newSeq.size % 2 == 0)
    {
      val first = newSeq(newSeq.size/2)
      val setcond = newSeq(newSeq.size/2 - 1)
      answer = (first + setcond).doubleValue() / 2
    }
    else
    {
      answer = newSeq(newSeq.size/2)
    }

    answer
  }

}
