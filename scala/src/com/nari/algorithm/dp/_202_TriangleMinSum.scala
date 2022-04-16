package com.nari.algorithm.dp

/*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
*/
object _202_TriangleMinSum {


  def minimumSum(triangle: List[List[Int]]): Int = {
    if (triangle.isEmpty) return 0
    val len = triangle.size
    var res: List[Int] = triangle(len - 1)
    for (i <- (0 to len - 2).reverse) { // 注意，scala的递减循环与java不同，通过更改被遍历集合顺序实现
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
