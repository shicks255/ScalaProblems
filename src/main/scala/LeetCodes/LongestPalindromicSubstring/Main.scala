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
  * Input: "abcdedcstoax"
  * Output: "cdedc"
  *
  * Input: "abcdefgsste"
  * Out: "ss"
  *
  */

package LeetCodes.LongestPalindromicSubstring

object Main extends App {

  println(longestPalindrome("babad"))

  def longestPalindrome(s: String): String = {
    var windowPaneSize = s.length
    while (windowPaneSize > 1)
      {
        var iter: Iterator[String] =  s.sliding(windowPaneSize)
        while (iter.hasNext)
          {
            val string: String = iter.next()
            if (isPalindrome(string))
              return string
          }

        windowPaneSize -= 1
      }

    ""
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
