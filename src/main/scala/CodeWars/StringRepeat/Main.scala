//https://www.codewars.com/kata/string-repeat/scala

package CodeWars.StringRepeat

object Main extends App{

  println(repeatStr(3, "*"))

  def repeatStr(times: Int, str: String): String = {
    var result = for (_ <- 0 until times) yield str

    result.mkString("")
  }

}
