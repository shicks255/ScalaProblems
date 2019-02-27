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

  def tail[A](list :List[A]): List[A] = {
    list match {
      case Nil => Nil
      case Cons(_,t) => t
    }
  }

  def drop[A](n: Int, list: List[A]): List[A] = {
      if (n > 0)
        drop(n-1, tail(list))
      else list
  }

  def dropWhile[A](f: A => Boolean, list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case Cons(h, t) => if (f(h)) dropWhile(f,t) else Cons(h,t)
    }
  }

  def setHead[A](a: A, list: List[A]): List[A] = {
    list match {
      case Nil => Cons(a, Nil)
      case Cons(h,t) => Cons(a, t)
    }
  }

//  def get[A](index: Int): A = {
//
//  }

}

object run extends App {

  val list: List[Int] = List(1,2,3,4,5)
  println(List.tail(list))
  println(List.drop(2, list))
  println(List.drop(0, list))

  val emptyList: List[Int] = Nil
  println(List.tail(emptyList))
  println(List.setHead("test", list))
  println(List.dropWhile[Int]((a: Int) => a <= 4, list))

//  val l = List(1,2,3,4)
//
//  println(l)
//  println(List.sum(l))
//  println(List.product(l))

//  val x = List(1,2,3,4,5) match {
//    case Cons(x, Cons(2, Cons(4, _))) => x
//    case Nil => 42
//    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
//    case Cons(h, t) => h + List.sum(t)
//    case _ => 101
//  }
//  println(x)

}