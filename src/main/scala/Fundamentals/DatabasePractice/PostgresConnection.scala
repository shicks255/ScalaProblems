package Fundamentals.DatabasePractice

import java.sql.DriverManager

import scala.collection.mutable.ListBuffer

class PostgresConnection(query: String) {

  def getResults(): List[User] = {
    PostgresConnection.fetchResults(query)
  }
}

object PostgresConnection {
  def fetchResults(query: String): List[User] = {
    val url = "jdbc:postgresql://192.168.1.14:5432/MusicReviews"
    val username = "shicks"
    val password = "ashley"

    val users = new ListBuffer[User]

    try
      {
        var connection = DriverManager.getConnection(url, username, password)
        var statement = connection.createStatement()
        val rs = statement.executeQuery(query)

        println(rs)
      }
    catch {
      case e: Exception => e.printStackTrace()
    }


    users.toList
  }
}
