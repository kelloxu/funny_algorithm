package com.nari.algorithm.link

import com.nari.algorithm.model.LinkNode

object _206_ReverseLinkedList {

  def reverse(head: LinkNode): LinkNode = {
    var cur: LinkNode = head;
    var prev: LinkNode = null;
    while (cur != null) {
      val temp = cur.next
      cur.next = prev
      prev = cur
      cur = temp
    }
    prev
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
