//https://www.codewars.com/kata/are-they-the-same/train/scala

package CodeWars.AreTheyTheSame

object Main extends App{

  val seq1 = Seq(121, 144, 19, 161, 19, 144, 19, 11)
  val seq2 = Seq(11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19)

  val seq3 = Seq(2, 2, 3)
  val seq4 = Seq(4, 9, 9)


//  println(comp(seq1, seq2)) // should return true;
  println(comp(seq3, seq4)) // should return false;

  def comp(seq1: Seq[Int], seq2: Seq[Int]): Boolean = {

    if (seq1 == null && seq2 == null)
      return true
    if ((seq1 == null && seq2 != null) || (seq2 == null && seq1 != null))
      return false
    if (seq1.isEmpty && seq2.isEmpty)
      return true
    if ((seq1.isEmpty && !seq2.isEmpty) || (seq2.isEmpty && !seq1.isEmpty))
      return false

    seq1.map(i => seq2.contains(i * i)).reduceLeft(_ && _)



  }
}
