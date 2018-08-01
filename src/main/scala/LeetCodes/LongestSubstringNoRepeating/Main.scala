package LeetCodes.LongestSubstringNoRepeating

import scala.collection.mutable

object Main extends App{

  println(lengthOfLongestSubstring2("pwwkew"))

  def lengthOfLongestSubstring2(s: String): Int = {

    var size: Int = 0

    for (x <- 0 until s.length)
      {
        var set: mutable.HashSet[Char] = new mutable.HashSet[Char]()
        val answer = s.substring(x).takeWhile(cha => set.add(cha))
        if (answer.size > size) size = answer.size
      }

    size
  }

}
