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

  def dropWhileCurried[A](list: List[A])(f: A => Boolean) = {
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

  def get[A](index: Int, list: List[A]): Option[A] = {
    list match {
      case Nil => None
      case Cons(h, t) => if (index == 0) Some(h) else get(index-1, t)
    }
  }

  def append[A](list: List[A], listFront: List[A]): List[A] = {
    listFront match {
      case Nil => list
      case Cons(h, t) => Cons(h, append(list, t))
    }
  }

  def init[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case Cons(h, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
    }
  }

  def foldRight[A, B](list: List[A], b: B)(f: (A,B) => B): B = {
    list match {
      case Nil => b
      case Cons(h, t) => f(h, foldRight(t, b)(f))
    }
  }

  def foldLeft[A,B](list: List[A], b: B)(f: (A,B) => B): B = {
    list match {
      case Nil => b
      case Cons(h, t) => foldLeft(t, f(h,b))(f)
    }
  }

  def length[A](list: List[A]): Int = {
    foldRight(list, 0)((x,y) => y+1)
  }

  def sumFoldLeft() = {

  }

  def productFoldLeft = {

  }

  def lengthFoldLeft() = {

  }

}

object run extends App {

  val list: List[Int] = List(1,2,3,4,5)
  println(List.tail(list))
  println(List.drop(2, list))
  println(List.drop(0, list))

  val emptyList: List[Int] = Nil
  println("tail:")
  println(List.tail(emptyList))
  println("sethead:")
  println(List.setHead("test", list))
  println("drop while")
  println(List.dropWhile[Int]((a: Int) => a <= 4, list))
  println("drop while curried:")
  println(List.dropWhileCurried(list)(_ < 5))
  println("get")
  println(List.get(3, list))
  println("get")
  println(List.get(5, list))
  println("append")
  println(List.append(List(), List(1,2,3)))
  println("init")
  println(List.init(list))
  println("foldRight")
  println(List.foldRight(List(1,2,3), 0)(_+_))
  println("length")
  println(List.length(List(1,2,3,4,5)))
  println("foldLeft")
  println(List.foldLeft(List("p", "e", "n", "c", "i", "l"), "")(_+_))
  println("foldRight")
  println(List.foldRight(List("p", "e", "n", "c", "i", "l"), "")(_+_))

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