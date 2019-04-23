package CodeWars.UnluckyDays

import java.time.LocalDate

object Solution extends App{

  def unluckyDays(year: Int): Int = {
    val dates = Array.tabulate(12)(x => LocalDate.of(year, x+1, 13))
    dates.filter(x => x.getDayOfWeek.ordinal() == 4).length
  }

  println(unluckyDays(1586) == 1, "should be: 1");
    println(unluckyDays(1001) == 3, "should be: 3");
    println(unluckyDays(2819) == 2, "should be: 2");
    println(unluckyDays(2792) == 2, "should be: 2");
    println(unluckyDays(2723) == 2, "should be: 2");
    println(unluckyDays(1909) == 1, "should be: 1");
    println(unluckyDays(1812) == 2, "should be: 2");
    println(unluckyDays(1618) == 2, "should be: 2");
    println(unluckyDays(2132) == 1, "should be: 1");
    println(unluckyDays(2065) == 3, "should be: 3");
    println(unluckyDays(2919) == 2, "should be: 2");

}
