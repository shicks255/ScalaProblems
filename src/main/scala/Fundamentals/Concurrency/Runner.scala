package Fundamentals.Concurrency
import scala.concurrent.Future

object Runner extends App {
  implicit  val ec = scala.concurrent.ExecutionContext.global

  def calculate(f: (Long, Long) => Double)(x: Long, y: Long): Future[Double] = {
    Future{
      f(x,y)
    }
  }

  val exponentior = calculate((x,y) => scala.math.pow(x,y)) _
  val result = for {
    r1 <- exponentior(1000,2)
    r2 <- exponentior(1000,3)
    r3 <- exponentior(1000,4)
    r4 <- exponentior(1000,5)
  } yield (r1,r2,r3,r4)

  Thread.sleep(50)
  println(result)


  val r1 = scala.math.pow(1000,2)
  val r2 = scala.math.pow(1000,3)
  val r3 = scala.math.pow(1000,4)
  val r4 = scala.math.pow(1000,5)

  val tup = (r1,r2,r3,r4)
  println(tup)

}
