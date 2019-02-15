package Fundamentals.Memo

import java.security.MessageDigest

object Runner extends App {
  val hasher: Hasher = new Hasher

  val hashedString1: String = hasher.memoMd5("test")
  println(hashedString1)
  val hashedString2: String = hasher.memoMd5("test")
  println(hashedString2)
  val hashedString3: String = hasher.memoMd5("test")
  println(hashedString3)

  println("done")
}

class Hasher extends Memoizer {
  val memoMd5 = memo(md5)

  def md5(input: String): String = {
    println("Calling MD5 for input " + input)
    Thread.sleep(1500)
    new String(MessageDigest.getInstance("MD5").digest(input.getBytes()))
  }
}

trait Memoizer {
  def memo[X,Y](f: X => Y): (X => Y) = {
    val cache = scala.collection.mutable.Map[X,Y]()
    (x: X) => cache.getOrElseUpdate(x, f(x))
  }
}
