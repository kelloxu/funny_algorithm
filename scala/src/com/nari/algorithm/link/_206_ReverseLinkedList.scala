package com.nari.algorithm.link

import com.nari.algorithm.model.LinkNode

object _206_ReverseLinkedList {

  def reverse(head: LinkNode): LinkNode = {

    // 方法1：迭代
//    var cur: LinkNode = head;
//    var prev: LinkNode = null;
//    while (cur != null) {
//      val temp = cur.next
//      cur.next = prev
//      prev = cur
//      cur = temp
//    }
//    prev

    // 方法2：递归
    reverse_recursion(head, null)
  }

  def reverse_recursion(cur: LinkNode, prev: LinkNode): LinkNode = {
    if (cur == null) return prev

    // scala 函数的形参为 val类型，不可改变，因此先将形参的值传给可变的量
    var curVar = cur
    var prevVar = prev
    val temp = curVar.next
    curVar.next = prevVar
    prevVar = curVar
    curVar = temp

    reverse_recursion(curVar, prevVar)
  }

  def main(args: Array[String]): Unit = {
    val node5 = new LinkNode(12, null)
    val node4 = new LinkNode(3, node5)
    val node3 = new LinkNode(7, node4)
    val node2 = new LinkNode(4, node3)
    val node1 = new LinkNode(8, node2)

    var res = reverse(node1)
    while ( {
      res != null
    }) {
      System.out.print(res.value+ "->")
      res = res.next
    }
    System.out.println("NULL")
  }
}
