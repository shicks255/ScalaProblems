package Fundamentals.Monoids

object MyMonoids {

  val intAddition: Monoid[Int] = new Monoid[Int] {
    override def op(l: Int, r: Int): Int = l + r
    override def zero: Int = 0
  }

  val intMultiplication: Monoid[Int] = new Monoid[Int] {
    override def op(l: Int, r: Int): Int = l * r
    override def zero: Int = 1
  }

  val stringConcat: Monoid[String] = new Monoid[String] {
    override def op(l: String, r: String): String = l + r
    override def zero: String = ""
  }

}
