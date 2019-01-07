package Fundamentals.TraitPractice

import scala.collection.mutable.ListBuffer

abstract class Product(val title: String, val price: Double) {
  def getName: String = title
  def getPrice: Double = price
}
class Book(title: String, price: Double)
  extends Product(title, price) with Ordered[Book] {
  override def toString: String = getName + " " + getPrice
  override def compare(that: Book): Int = title.compareTo(that.title)
}

trait Hardcover extends Product {
  override def getPrice: Double = super.getPrice + 10
  override def getName: String = super.getName + ": Hardcover"
}
trait EBook extends Product {
  override def getPrice: Double = super.getPrice - 4
  override def getName: String = super.getName + ": Ebook"
}

object bookRunner extends App {
  val paperBacks = new ListBuffer[Book]
  paperBacks += new Book("Huckleberry Finn", 12)
  paperBacks += new Book("Dracula", 8)
  paperBacks += new Book("The Red Badge of Courage", 15)
  paperBacks += new Book("Fatal Vision", 12)

  val hardBooks = paperBacks.map(x => new Book(x.getName, x.getPrice) with Hardcover)
  val ebooks = paperBacks.map(x => new Book(x.getName, x.getPrice) with EBook)
  val allBooks = List.concat(paperBacks, hardBooks, ebooks).sorted

  println(allBooks.mkString("\n"))
}


