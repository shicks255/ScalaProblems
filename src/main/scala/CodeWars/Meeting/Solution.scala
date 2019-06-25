package CodeWars.Meeting

object Solution extends App{

  val answer: String = meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn")
  print(answer)

  def sortPeople(one: (String,String), two: (String, String)): Boolean = {
    one._2.compareTo(two._2) match {
      case x if x < 0 => true
      case x if x > 0 => false
      case _ => if (one._1.compareTo(two._1) > 0) false else true
    }
  }

  def meeting(s: String): String = {
    val splits: Array[String] = s.split(";")
    val newSplits = splits.map(x => x.split(":")).map(y => (y(0).toUpperCase(), y(1).toUpperCase()))
    val finalSplits = newSplits.sortWith((a,b) => sortPeople(a,b))
    val answer = finalSplits.map(t => "(" + t._2 + ", " + t._1 +")")

    answer.fold("")(_+_)
  }


}
