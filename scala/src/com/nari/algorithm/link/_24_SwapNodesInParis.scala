package com.nari.algorithm.link

import com.nari.algorithm.model.LinkNode

/**
 * Author: Xu Jiong
 * Date: 2022/5/17 17:04
 * Description: 
 */
object _24_SwapNodesInParis {

  def swapPairs(head: LinkNode): LinkNode = {

    // 新增虚节点，指向 head
    val dumpy = new LinkNode(0)
    dumpy.next = head

    // dumpy 赋给 cur
    var cur = dumpy

    // 开始迭代
    // 1. 当 cur.next = None 时，说明已经遍历到最后一个节点，迭代可以结束了
    // 2. 当 cur.next = None 时，说明链表的节点数是奇数，还剩最后一个节点，无法交换了，迭代也可以结束了
    while (cur.next != null && cur.next.next != null) {
      val temp1 = cur.next
      val temp2 = cur.next.next.next
      cur.next = cur.next.next
      cur.next.next = temp1
      cur.next.next.next = temp2
      cur = cur.next.next
    }
    dumpy.next
  }


  def main(args: Array[String]): Unit = {

    val node5 = new LinkNode(5, null)
    val node4 = new LinkNode(4, node5)
    val node3 = new LinkNode(3, node4)
    val node2 = new LinkNode(2, node3)
    val node1 = new LinkNode(1, node2)

    var res = swapPairs(node1)
    while (res != null) {
      System.out.print(res.value + "->")
      res = res.next
    }
    System.out.println("NULL")
  }
}
