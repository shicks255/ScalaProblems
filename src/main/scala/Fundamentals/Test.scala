package Fundamentals

object Test extends App{

  val t = new Test()
  t.print

//  def tryThis(x: Test) = {
//    println(x);
//  }

}


class Test[T] {

  def print = println("hi");

}
