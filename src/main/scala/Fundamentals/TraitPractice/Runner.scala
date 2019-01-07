package Fundamentals.TraitPractice

object Runner extends App {

  val base = new Base()
  println(base.name)
  println(base.func)
}

class Base() extends T1 with T2 {
  override def name = "Base Class"
  override def func: String = super.func
}

trait T1 {
  def name = "Trait 1"
  def func: String = name + " from trait 1"
}

trait T2 extends T1 {
  override def name: String = "Trait 2"
  override def func: String = super.func + " called from T2"
}
