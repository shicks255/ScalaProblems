//package Fundamentals.OptionForLoops.LoginProgram
//
//case class IO(run: String => String) {
//
//  def map(f: String => String): IO = {
//    flatMap(a => IO(f))
//  }
//
//  def flatMap(f: String => IO): IO = {
//    val result1 = f(run)
//    val result2 = result1.run
//    IO(result2)
//  }
//}
