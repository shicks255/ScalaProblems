package Fundamentals.DatabasePractice

import java.time.LocalDate

class Purchase(oD: LocalDate, t: String, p: Float, a: String) {

  val orderDate = oD
  val title = t
  val price = p
  val address = a

  override def toString(): String = "Date: " + orderDate + " title: " + title + " price: " + price + " " + address
}
