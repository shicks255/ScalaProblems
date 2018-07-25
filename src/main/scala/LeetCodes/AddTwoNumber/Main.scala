//https://leetcode.com/problems/add-two-numbers/description/
/**
  *
  * You are given two non-empty linked lists representing two non-negative integers.
  * The digits are stored in reverse order and each of their nodes contain a single digit.
  * Add the two numbers and return it as a linked list.
  *
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  *
  * Example
  *
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * Explanation: 342 + 465 = 807.
  *
  */


package LeetCodes.AddTwoNumber

import scala.collection.mutable.ArrayBuffer

object Main  extends App{
  var node1 = new ListNode(2)
  var node1_a = new ListNode(4)
  var node1_b = new ListNode(3)
  node1.next = node1_a
  node1_a.next = node1_b

  var node2 = new ListNode(5)
  var node2_a = new ListNode(6)
  var node2_b = new ListNode(4)
  node2.next = node2_a
  node2_a.next = node2_b

  println(addTwoNumber(node1, node2))


  def addTwoNumber(l1: ListNode, l2: ListNode): Unit = {
    var carryTen: Boolean = false

    var node1 = l1;
    var node2 = l2

    var numbers = new ArrayBuffer[Int]

    while (node1 != null && node2 != null)
    {
      val num1: Int = if (node1 != null) node1.x else 0
      val num2: Int = if (node2 != null) node2.x else 0

      var sum: Int = num1 + num2
      if (carryTen)
        {
          carryTen = false
          sum += 1
        };

      if (sum > 9)
        {
          sum = sum - 10
          carryTen = true
        };

      node1 = node1.next
      node2 = node2.next

      numbers += sum
    }

    val nodes :ArrayBuffer[ListNode] = numbers.map(x => new ListNode(x))

    val test = "test"

    val node = nodes.reduceLeft(reduce())
  }

  def reduce(x :ListNode, y :ListNode): ListNode =
  {
    x.next = y
    y
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x;
}
