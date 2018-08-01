package Fundamentals

object CollectionsStuff extends App{

  playWithTraversable()


  def playWithTraversable(): Unit = {

    val aList: List[Int] = List(1, 2, 3, 4, 5)
    val aSeq: Seq[Int] = Seq(2, 4, 6, 8, 10)

    val iter: Iterator[Seq[Int]] = aSeq.grouped(2)
    val sliding: Iterator[Seq[Int]] = aSeq.sliding(3)

    println(iter)
  }


}
