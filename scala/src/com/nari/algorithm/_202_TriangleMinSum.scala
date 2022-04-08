package com.nari.algorithm

import scala.math

/*
* 题目地址：https://leetcode-cn.com/problems/triangle/
* 题目概述：Given a triangle array, return the minimum path sum from top to bottom
           For each step, you may move to an adjacent number of the row below. More formally,
           if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 Example:
 Input: triangle = [[2],[3,2],[6,5,4],[4,1,100,101]]
 Output: 11
 Explanation: The triangle looks like:
    2
   3 2
  6 5 4
 4 1 100 101
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
object _202_TriangleMinSum {


  def minimumSum(triangle: List[List[Int]]): Int = {
    if (triangle.isEmpty) return 0
    val len = triangle.size
    var res: List[Int] = triangle(len - 1)
    for (i <- (0 to len - 2).reverse) {  // 注意，scala的递减循环与java不同，通过更改被遍历集合顺序实现
      for (j <- triangle(i).indices) {
        val ijState = triangle(i)(j) + math.min(res(j), res(j + 1))
        res = res.updated(j, ijState)
      }
    }
    res.head
  }


  def main(args: Array[String]): Unit = {
    val triangle: List[List[Int]] = List(List(2), List(3, 2), List(6, 5, 4), List(4, 1, 100, 101))
    println(minimumSum(triangle))
  }
}
