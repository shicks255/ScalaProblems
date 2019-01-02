package Fundamentals.DatabasePractice

import java.time.LocalDate

class Purchase(orderDate: LocalDate, title: String, price: Float, address: String) {

  override def toString(): String = "Date: " + orderDate + " title: " + title + " price: " + price + " " + address



}
