package Fundamentals

import scala.io.Source

object FileStuff extends App{

//readFromFile()
readURL()

  def readURL() = {
    val source = Source.fromURL("http://shicks255.com")

    val it = source.getLines()

    it.foreach(x => println(x))

  }

  def readFromFile() = {

    val source = Source.fromFile("readFromFile.txt", "UTF-8")

    val lineIterator = source.getLines()

    for (i <- lineIterator)
      println(i)

  }

}
