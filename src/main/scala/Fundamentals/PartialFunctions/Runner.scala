package Fundamentals.PartialFunctions

object Runner {

  def main(args: Array[String]):Unit = {

    val test1 = runTest("one")
    val test2 = runTest("2")

    println(test1)
    println(test2)

  }

  def runTest(x:String):Option[Int] = {
    test.isDefinedAt(x) match {
      case true => Some(test.apply(x))
      case false => None
    }
  }

  def test = new PartialFunction[String, Int] {
    override def isDefinedAt(x: String): Boolean = {
      val answer = try{
        x.toInt
        true
      }
      catch {
        case e: Exception => false
      }
      answer
    }

    override def apply(v1: String): Int = {
      v1.toInt
    }
  }


}
