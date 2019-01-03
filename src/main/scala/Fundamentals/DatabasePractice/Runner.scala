package Fundamentals.DatabasePractice

object Runner extends App{

  val connection: MySQLConnection = new MySQLConnection("select * from purchases")

  val allPurchases = connection.getResults()
//  println(allPurchases.mkString("\n, "))

  val under15 = allPurchases.filter(x => x.price > 150).sortWith((x,y) => x.orderDate.isAfter(y.orderDate))
//  println(under15.mkString("\n"))

  val under152 = for {
    x <- allPurchases
    val price = x.price
    if price < 5
  } yield x

  println(under152.mkString("\n"))
}
