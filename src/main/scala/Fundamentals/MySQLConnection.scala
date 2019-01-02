package Fundamentals

import java.sql.{Connection, DriverManager}

object MySQLConnection extends App{

  val url = "jdbc:mysql://192.168.1.14:8888/Amazon"
  val driver = "mysql-connector-java-5.1.39-bin"
//  val driver = "com.mysql.jdbc.Driver"
  val username = "shicks"
  val password = ""

  var connection: Connection = _
  try
    {
//      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val rs = statement.executeQuery("select * from purchases")
      while (rs.next)
        {
          val title = rs.getString("title")
          var date = rs.getDate("order_date")
          var price = rs.getString("purchase")
          println(s"$title $date $$$price")
        }
    }
  catch
    {
      case e: Exception => e.printStackTrace()
    }

  connection.close()

}
