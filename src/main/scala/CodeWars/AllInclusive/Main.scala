package CodeWars.AllInclusive

import scala.collection.mutable.ArrayBuffer

object Main extends App{
  var arr = List("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
  print(containAllRots2("bsjq", arr))

  def containAllRots(strng: String, arr: List[String]): Boolean = {

    var charArray = strng.toCharArray
    var rots = ArrayBuffer[String]()

     var arrayOfRots = for (_ <- 0 until strng.length)
     {
       var temp = charArray(0)
       for (x <- 1 until strng.length)
         charArray(x-1) = charArray(x)
       charArray(strng.length - 1) = temp
       rots += charArray.mkString("")
    }

    for (rot <- rots)
        if (!arr.contains(rot))
          return false;

    true
  }

  def containAllRots2(strng: String, arr: List[String]): Boolean = {

    val length = strng.length //4
    //this next line is basically saying, for each letter, do a loop, and in that loop,
    //grab the last lett
    val newArray = (1 to length).map(i => strng.substring(length - i).concat(strng.substring(0, length - i)))

    newArray.map(i => arr.contains(i)).reduceLeft((a,b) => a && b)

  }

}
