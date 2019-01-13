package Fundamentals.CaseClassesAndPatternMatching

object Runner extends App{

  val x: Int = 3

  val y: String = x match {
    case 1 => "this is a one"
    case 2 => "this is a two"
    case 3 => "this is a three"
    case _ => "what on earth"
  }
//  println(y)

  abstract class Notification
  case class Text(from: String, message: String) extends Notification
  case class Call(from: Long, voiceMail: String) extends Notification
  case class Email(from: String, email: String, body: String) extends Notification

//  Type matching
  def sendNotification(n: Notification): String = {
    n match {
      case t: Text => n.toString
      case c: Call => n.toString
      case e: Email => n.toString
    }
  }

//  Constructor matching
  def sendNotification2(n: Notification): String = {
    n match {
      case Call(from,_) => s"you got a call from $from"
      case Text(from,msg) => s"you got a text from $from - message: $msg"
      case Email(from,at,_) => s"you got an email from $from - $at"
    }
  }

  println(sendNotification2(Text("Steph", "hey, what's up")))
  println(sendNotification2(Call(9087970867L, "Please call me back")))
  println(sendNotification2(Email("Dad", "tghicks@comcast.net", "Did you order the new receiver?")))
}

//variable binding
object Runner2 extends App {

  abstract class makeUpper
  case class makeUpperCase(s: Any) extends makeUpper

  def getValue(m: makeUpper): String = m match {
    case makeUpperCase(e @ makeUpperCase(x)) =>
      {
        println("WOW thats something, lets trim it down")
        getValue(e)
      }
    case makeUpperCase(x) if x.isInstanceOf[String] => x.toString.toUpperCase()
    case _ => "woah woah woah, calm down, strings only"
  }

  println(getValue(makeUpperCase(makeUpperCase("hi"))))
  println(getValue(makeUpperCase(4)))
}

//list matching
object Runner3 extends App {

  val testList1 = List(1,2,3,4)
  val testList2 = List(1,2,3)
  val testList3 = List(2,2,2)

  testList(testList1)
  testList(testList2)
  testList(testList3)

  def testList(x: List[Int]) = x match {
    case List(1,_,_) => println("3 length list starting with 1 detected")
    case List(_,_,_) => println("3 length list detected")
    case List(_*) => println("list of any length detected")
  }
}

object Runner4 extends App {


}