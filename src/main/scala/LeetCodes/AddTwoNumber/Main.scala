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
  var node1 = new ListNode(1)
  var node11 = new ListNode(8)
  node1.next = node11
  var node2 = new ListNode(0)

  var node3 = new ListNode(2)
  var node3a = new ListNode(4)
  var node3b = new ListNode(3)
  node3.next = node3a
  node3a.next = node3b

  var node4 = new ListNode(5)
  var node4a = new ListNode(6)
  var node4b = new ListNode(4)
  node4.next = node4a
  node4a.next = node4b

  println(addTwoNumber(node1, node2))


  def addTwoNumber(l1: ListNode, l2: ListNode): ListNode = {
    var list1 :ArrayBuffer[ListNode] = ArrayBuffer()
    var nodeA = l1;
    while (nodeA != null)
      {
        list1 += nodeA;
        nodeA = nodeA.next
      }

    var list2 :ArrayBuffer[ListNode] = ArrayBuffer()
    var nodeB = l2;
    while (nodeB != null)
      {
        list2 += nodeB;
        nodeB = nodeB.next
      }

    var nums = list1.zipAll(list2, new ListNode(0), new ListNode(0))
    var summedNodes :ArrayBuffer[ListNode] = nums.map(tup => new ListNode(tup._1.x + tup._2.x))

    for (i <- 0 until summedNodes.size)
      {
        if (summedNodes(i).x > 9)
          {
            summedNodes(i).x = summedNodes(i).x - 10
            if (i == summedNodes.size-1)
              summedNodes.append(new ListNode(1))
            else
              summedNodes(i+1).x = summedNodes(i+1).x + 1
          }
        if (i < summedNodes.size-1) summedNodes(i).next = summedNodes(i + 1)
      }

    summedNodes(0)
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x;
}
