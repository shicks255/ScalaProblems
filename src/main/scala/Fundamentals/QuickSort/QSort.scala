package Fundamentals.QuickSort

object QSort extends App{

  val unsorted = Array(0,4,1,5,6)
  val sorted = QuickSort(unsorted)

  print(sorted)

  def QuickSort(array: Array[Int]) = {
    sort(array, 0, array.length-1)

    def sort(array: Array[Int], start: Integer, end: Integer): Option[Array[Int]] = {
      if (start >= end)
        return Some(array)
      else {
        val piv: Int = pivot(array, start, end)
        sort(array, start, piv-1)
        sort(array, piv, end)
      }
      return None
    }

    def pivot(array: Array[Int], start: Int, end: Int) = {
      var counter = start
      var endd = end
      while (counter < endd){
        if (array(counter) >= array(endd)) {
          swap(array, counter, endd-1)
          swap(array, endd, endd-1)
          endd -= 1
        }
        else {
          counter += 1
        }
      }

      endd
    }

    def swap(array: Array[Int], a: Int, b: Int): Unit = {
      val temp = array(a)
      array(a) = array(b)
      array(b) = temp
    }

    array
  }
}
