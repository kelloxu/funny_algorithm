package com.nari.algorithm

import scala.collection.mutable

import model.Node

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/3/13
 * Time: 12:16
 * Description: 
 */
object _102_BinaryTreeLevelOrderTraversal {

  def levelOrder(root: Node): List[List[Int]] = {
    var res: List[List[Int]] = List()
    if (root == null) {
      return res
    }

    val queue: mutable.Queue[Node] = new mutable.Queue[Node]()
    queue += root

    while (queue.nonEmpty) {
      val current_level_size = queue.size
      var current_node_vals: List[Int] = List()
      for(_ <- 0 until current_level_size) {
        val node: Node = queue.dequeue()
        current_node_vals = current_node_vals :+ node.value
        if (node.left != null) {
          queue += node.left
        }
        if (node.right != null) {
          queue += node.right
        }
      }
      res = res :+ current_node_vals
    }

    res

  }

  def main(args: Array[String]): Unit = {
    //       88
    //    5       7
    // 2   10   4   22
    val node31: Node = new Node(2)
    val node32: Node = new Node(10)
    val node33: Node = new Node(4)
    val node34: Node = new Node(22)
    val node21: Node = new Node(5, node31, node32)
    val node22: Node = new Node(7, node33, node34)
    val node11: Node = new Node(88, node21, node22)
    println(levelOrder(node11))
  }
}
