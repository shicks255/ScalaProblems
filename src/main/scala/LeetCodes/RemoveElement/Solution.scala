package LeetCodes.RemoveElement

import scala.annotation.tailrec

object Solution extends App{

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    @tailrec
    def recursive(nums: Array[Int], `val`: Int, index: Int = 0): Int = {
     if (index == nums.length-1)
       return nums.indexWhere(_ == `val`)

      //found one we need to remove, so were going to swap it with
      //the last one that DOESN'T need to be removed
      if (nums(index) == `val`)
        {
          val swapIndex: Int = nums.lastIndexWhere(_ != `val`)
          if (swapIndex > index)
            {
              val temp: Int = nums(swapIndex)
              nums(swapIndex) = nums(index)
              nums(index) = temp
            }
        }

      recursive(nums, `val`, index+1)
    }
    val answer = recursive(nums, `val`)
    println(answer)
    answer
  }

//  assert(removeElement(Array(3,2,2,3), 3) == 2)
//  assert(removeElement(Array(0,1,2,2,3,0,4,2), 2) == 5)
  assert(removeElement(Array(0), 1) == 1)

}
