//https://www.codewars.com/kata/alphabetically-ordered/train/scala

package CodeWars.AlphabeticallyOrdered

object Main extends App{

  println(isAlphabetic("asd"))     //false
  println(isAlphabetic("codewars")) //false
  println(isAlphabetic("door"))    //true
  println(isAlphabetic("cell"))    //true
  println(isAlphabetic("z"))       //true
  println(isAlphabetic(""))        //true

  def isAlphabetic(s: String): Boolean = {
    var alpha = true

    for (i <- 1 until s.length)
      {
        if (s(i) < s(i-1))
          alpha = false
      }

    alpha
  }
}
