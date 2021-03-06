//https://www.codewars.com/kata/century-from-year/train/scala
/**
The first century spans from the year 1 up to
and including the year 100,
The second - from the year 101 up to
and including the year 200, etc.

  Task :
  Given a year, return the century it is in.

Input , Output Examples ::
centuryFromYear(1705)  returns (18)
centuryFromYear(1900)  returns (19)
centuryFromYear(1601)  returns (17)
centuryFromYear(2000)  returns (20)
**/

package CodeWars.CenturyFromYear

object CenturyYear {
  def centuryFromYear(year: Int): Int =
  {
    val suffix = year.toString.takeRight(2).toInt
    val prefix = year.toString.take(year.toString.size - 2).toInt

    if (suffix > 0)
      prefix + 1
    else
      prefix
  }
}

object Main2{
  def main(args: String) = {
    println(CenturyYear.centuryFromYear(1705))
    println(CenturyYear.centuryFromYear(1900))
  }
}
