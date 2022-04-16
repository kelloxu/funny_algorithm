package com.nari.algorithm

import model.Node

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
object _236_LowestCommonAncestorOfBT {


  def lowestCommonAncestor(root: Node, p: Node, q: Node): Node = {
    if (root == null || root == p || root == q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left == null) return right
    if (right == null) return left
    root
  }


  def main(args: Array[String]): Unit = {
    //       88
    //    5        7
    // 2   10    4    22
    //9 7 20 100
    val node41 = new Node(9)
    val node42 = new Node(7)
    val node43 = new Node(20)
    val node44 = new Node(100)
    val node31 = new Node(2, node41, node42)
    val node32 = new Node(10, node43, node44)
    val node33 = new Node(4)
    val node34 = new Node(22)
    val node21 = new Node(5, node31, node32)
    val node22 = new Node(7, node33, node34)
    val node11 = new Node(88, node21, node22)
    println(lowestCommonAncestor(node11, node31, node44).value)
  }

}
