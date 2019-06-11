package CodeWars.RemovingElements

object Solution extends App{

  println(removeEveryOther2(List(1,2,3,4)))
  println(removeEveryOther2(List(List(1,2))))
  println(removeEveryOther2(List("Hello", "Goodbye", "Hello Again")))

  def removeEveryOther[T](list: List[T]): List[T] = {
    val zipped = list.zipWithIndex
    val removeEveryOther = zipped.filter((x) => x._2 % 2 == 0)
    removeEveryOther.unzip._1
  }

  def removeEveryOther2[T](list: List[T]): List[T] = {
    val answer =for {
      (i,x) <- list.zipWithIndex
      if x % 2 == 0
    } yield i
    answer
  }
}
