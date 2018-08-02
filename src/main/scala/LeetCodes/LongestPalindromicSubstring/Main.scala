//https://leetcode.com/problems/longest-palindromic-substring/description/

/**
  *
  * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  *
  * Example 1:
  *
  * Input: "babad"
  * Output: "bab"
  * Note: "aba" is also a valid answer.
  * Example 2:
  *
  * Input: "cbbd"
  * Output: "bb"
  *
  */

package LeetCodes.LongestPalindromicSubstring

import scala.collection.mutable

object Main extends App {

  longestPalindrome("aba")

  def longestPalindrome(s: String): String = {

    println(isPalindrome(s))
    "S"
  }

  def isPalindrome(s: String): Boolean = {
    if (s.length == 1)
      true
    if (s.length == 2 && s(0) == s(1))
      true

    var stck1 = scala.collection.mutable.Stack[Char]()
    var stck2 = scala.collection.mutable.Stack[Char]()

    s.foreach(x => stck1.push(x))
    s.reverse.foreach(x => stck2.push(x))

    for (x <- 0 until s.length)
      {
        if (stck1.pop != stck2.pop)
          return false
      }

    true
  }

}
