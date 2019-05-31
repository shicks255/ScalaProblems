package Fundamentals.MergeSort

object MSort extends App{

  val array = Array(0,3,1,8,5,4)
  val sortedArray = mergeSort(array)

  println(sortedArray)


  def mergeSort(array: Array[Int]): Array[Int] =
  {
    sort(array, 0, array.size-1)
    array
  }

  def sort(array: Array[Int], left: Int, right: Int): Unit =
  {
    if (left >= right)
      return

    val mid: Int = (right+left)/2
    sort(array, left, mid)
    sort(array, mid+1, right)
    mergeHalves(array, left, right)
  }

  def mergeHalves(array: Array[Int], left: Int, right: Int): Unit =
  {
    val mid = (right+left)/2

    val tempSizeLeft = mid-left+1
    val tempSizeRight = right-mid

    val tempLeft: Array[Int] = new Array(tempSizeLeft)
    val tempRight: Array[Int] = new Array(tempSizeRight)

    for (i <- 0 until tempSizeLeft)
      tempLeft(i) = array(left+i)
    for (i <- 0 until tempSizeRight)
      tempRight(i) = array(mid+i+1)

    var l = 0
    var r = 0
    var s = left

    while (l < tempSizeLeft && r < tempSizeRight)
      {
        if (tempLeft(l) <= tempRight(r)){
          array(s) = tempLeft(l)
          l += 1
        }
        else{
          array(s) = tempRight(r)
          r += 1
        }

        s += 1
      }

    while (l < tempSizeLeft){
      array(s) = tempLeft(l)
      s += 1
      l += 1
    }
    while (r < tempSizeRight){
      array(s) = tempRight(r)
      s += 1
      r += 1
    }
  }

}
