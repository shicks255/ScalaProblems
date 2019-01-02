package Fundamentals.DatabasePractice

import java.sql.{DriverManager, ResultSet}

import scala.collection.mutable.ListBuffer

class MySQLConnection(query: String) {

  def getResults(): List[Purchase] = {
    MySQLConnection.fetchResults(query)
  }
}

object MySQLConnection {
  def fetchResults(query: String): List[Purchase] = {
    val url = "jdbc:mysql://192.168.1.14:8888/Amazon"
    val username = "shicks"
    val password = "ashley"

    var purchases = new ListBuffer[Purchase]

    try {
      var connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val rs = statement.executeQuery(query)
      while (rs.next)
      {
        val title = rs.getString("title")
        val date = rs.getDate("order_date").toLocalDate
        val price = rs.getFloat("purchase")
        val address = rs.getString("shipping_address")
        val purchase: Purchase = new Purchase(date, title, price, address)
        purchases += purchase
      }
      connection.close()
    }
    catch {
      case e: Exception => e.printStackTrace()
    }

    purchases.toList
  }
}
