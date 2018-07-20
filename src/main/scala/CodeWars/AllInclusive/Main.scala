package CodeWars.AllInclusive

object Main extends App{
  var a = List("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
  containAllRots("bsjq", a)

  def containAllRots(string: String, arr: List[String]): Boolean = {

    var array = string.toCharArray

    val thing = for (i <- 0 until string.length) yield {

      val temp = arr(i)
      var newArray = array
      newArray(i) =
    }

    true
  }

}
