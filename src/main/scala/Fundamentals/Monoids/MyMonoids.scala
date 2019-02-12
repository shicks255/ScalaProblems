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

  def fold[T](m: Monoid[T], l: List[T]): T = {
    l.foldLeft(m.zero)(m.op)
  }

  def foldMap[T, Y](m: Monoid[T], l: List[Y])(f: Y => T) = {
    l.foldLeft(m.zero){
      case (t, y) => m.op(t, f(y))
    }
  }

  def balancedFold[T](m: Monoid[T], l: List[T]): T = {
    l.size match {
      case x if x == 0 => m.zero
      case x if x == 1 => l.head
      case _ => {
        val (left, right) = l.splitAt(l.length/2)
        m.op(balancedFold(m,left), balancedFold(m, right))
      }
    }
  }

}
