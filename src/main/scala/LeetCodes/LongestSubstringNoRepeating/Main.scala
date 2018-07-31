package LeetCodes.LongestSubstringNoRepeating

import scala.collection.mutable

object Main extends App{

  println(lengthOfLongestSubstring("pwwkew"))

  def lengthOfLongestSubstring(s: String): Int = {

    var size: Int = 0;
    for (x <- 0 until s.length)
      {
        val answer: Int = getUniques(s.substring(x))
        if (answer > size)
          size = answer
      }

    size
  }

  def getUniques(s: String): Int = {
    var set: mutable.HashSet[Char] = new mutable.HashSet[Char]

    var index = 0
    while (index < s.size && set.contains(s.charAt(index)) == false )
      {
        set += s.charAt(index)
        index += 1
      }

    set.size
  }
}
