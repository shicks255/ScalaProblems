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

  def sendNotification(n: Notification): String = {
    n match {
      case t: Text => n.toString
      case c: Call => n.toString
      case e: Email => n.toString
    }
  }

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
