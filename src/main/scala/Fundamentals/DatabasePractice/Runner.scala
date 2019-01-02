package Fundamentals.DatabasePractice

object Runner extends App{

  val connection: MySQLConnection = new MySQLConnection("select * from purchases")

  val allPurchases = connection.getResults()

  print(allPurchases.mkString(", "))

}
