package Fundamentals.FunctionalProgrammingInScala.Chapter3


sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ints: List[Int]): Int = ints match {
    case Nil => 1
    case Cons(0, _) => 0
    case Cons(h, t) => h * product(t)
  }

  def apply[A](a: A*): List[A] = {
    if (a.isEmpty)
      Nil
    else
      Cons(a.head, apply(a.tail: _*))
  }

//  def get[A](index: Int): A = {
//
//  }

}

object run extends App {

//  val l = List(1,2,3,4)
//
//  println(l)
//  println(List.sum(l))
//  println(List.product(l))

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
  }

  println(x)

}