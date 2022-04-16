package com.nari.algorithm

/*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
object _122_BestTime2BuyAndSellStock {

  def maxProfit(prices: Array[Int]) : Int = {
    var maxValue = 0
    for (i <- 0 until prices.length - 1) {
      if (prices(i) < prices(i + 1)) {
        maxValue += prices(i + 1) - prices(i)
      }
    }
    maxValue
  }

  def main(args: Array[String]): Unit = {
    val prices: Array[Int] = Array(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))
  }
}
