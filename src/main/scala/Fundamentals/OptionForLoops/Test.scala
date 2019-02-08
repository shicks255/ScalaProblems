package Fundamentals.OptionForLoops

object Test extends App{

  def getOption1(x : String): Option[Int] = {
    try
    {
      Some(x.toInt)
    }
    catch {
      case e: Exception => None
    }
  }

  val answer = for {
    y <- getOption1("1")
    x <- getOption1("2")
    j <- getOption1("three")
  } yield {y + x}

  println(answer)
}
