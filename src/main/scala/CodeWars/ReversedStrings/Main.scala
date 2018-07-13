package CodeWars.ReversedStrings

object Main extends App{

  println(solution("world"))
  println("test")

  def solution(word: String): String = {
    word.reverse
  }
}
