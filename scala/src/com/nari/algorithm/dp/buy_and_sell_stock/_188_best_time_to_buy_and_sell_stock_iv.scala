package com.nari.algorithm.dp.buy_and_sell_stock

/**
 * Author: Xu Jiong
 * Date: 2022/4/25 9:49
 * Description: 动态规划系列 —— 买卖股票4
 * 最多可以买卖 k 次
 * 手中最多可以持有一股，即如果手中有股票的话，要想再买，必须先卖出手中的股票
 */
object _188_best_time_to_buy_and_sell_stock_iv {

  /**
   * 计算最大收益
   *
   * @param k      交易次数
   * @param prices 股价数组
   * @return 最大收益
   */
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    var K = k
    if (K <= 0 || prices == null || prices.length == 0) return 0
    val n: Int = prices.length // 交易次数

    // 定义状态变量
    val dp = Array.ofDim[Int](n, K + 1, 2)

    // 定义结果列表
    var res: List[Int] = List()

    // 当最大交易次数 k 大于交易天数的一半时，等同于不限次数交易（即122题），可以用贪心算法解决，否则 LeetCode 会超时
    // 也可以直接把超大的 k 替换为数组的一半，这样就不用写额外的贪心算法函数了
    if (K > n / 2) {
//      K = n / 2
      return greedy(prices)
    }

    // 状态初始化
    for (kk <- 0 to K) {
      dp(0)(kk)(0) = 0
      dp(0)(kk)(1) = -prices(0)
    }

    // 状态转移方程
    for (i <- 1 until n) {
      System.out.println("第 " + (i + 1) + "天交易")

      for (j <- 0 to K) {
        System.out.println("   第 " + j + "次交易")
        if (j == 0) {
          dp(i)(j)(0) = dp(i - 1)(j)(0)
        } else {
          dp(i)(j)(0) = Math.max(dp(i - 1)(j)(0), dp(i - 1)(j - 1)(1) + prices(i))
        }
        dp(i)(j)(1) = Math.max(dp(i - 1)(j)(1), dp(i - 1)(j)(0) - prices(i))
      }
    }

    for (m <- 0 to K) {
      res = res :+ (dp(n - 1)(m)(0))
    }

    res.max
  }

  /**
   * 贪心算法
   *
   * @param prices 股价数组
   * @return 局部最大收益
   */
  def greedy(prices: Array[Int]): Int = {
    var res = 0;
    for (i <- 1 until prices.length) {
      if (prices(i) > prices(i - 1)) {
        res += (prices(i) - prices(i - 1))
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val k: Int = 2
    val prices: Array[Int] = Array(3, 2, 6, 5, 0, 3)
    println(maxProfit(2, prices))
  }
}
