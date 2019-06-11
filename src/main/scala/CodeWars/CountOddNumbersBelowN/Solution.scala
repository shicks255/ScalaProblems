package CodeWars.CountOddNumbersBelowN

object Solution extends App{

  println(oddCount(15))
  println(oddCount(17643720854L))


  def oddCount(n: Long): Long = {
    n/2
  }

}
