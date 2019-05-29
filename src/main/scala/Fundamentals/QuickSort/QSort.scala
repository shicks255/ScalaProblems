package Fundamentals.QuickSort

object QSort extends App{

  val unsorted = Array(0,4,1,5,6)
  val sorted = QuickSort(unsorted)

  print(sorted)

  def QuickSort(array: Array[Int]) = {
    sort(array, 0, array.length-1)

    def sort(array: Array[Int], start: Integer, end: Integer): Option[Array[Int]] = {
      (start >= end) match {
        case true => return Some(array)
        case false => {
          val piv: Int = pivot(array, start, end)
          sort(array, start, piv-1)
          sort(array, piv, end)
        }
      }

      return None
    }

    def pivot(array: Array[Int], start: Int, end: Int) = {
      var left = start
      var right = end
      while (left < right){
        if (array(left) >= array(right)) {
          swap(array, left, right-1)
          swap(array, right, right-1)
          right -= 1
        }
        else {
          left += 1
        }
      }

      right
    }

    def swap(array: Array[Int], a: Int, b: Int): Unit = {
      val temp = array(a)
      array(a) = array(b)
      array(b) = temp
    }

    array
  }
}
