package Fundamentals

import scala.io.Source

object Test extends App{

  val files = Source.fromFile("readFromFile.txt", "UTF-8")

  for (file <- files.getLines())
    println(file)

  def scalaFiels = for (file <- files.getLines() if file.endsWith(".scala"))
    yield file

  for (file <- files.getLines()
        if file.endsWith(".scala")
        if file.length > 2)
    println(file)

}
