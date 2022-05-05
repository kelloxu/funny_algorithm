"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
题目描述：
        动态规划系列 —— 买卖股票
        股价不小于1： 1 <= prices[i] <= 50000
        不限次数买卖
        每次交易有手续费: 0 <= fee <= 50000
"""

from typing import List


class Solution714:

    def max_profit(self, prices: List[int], fee: int) -> int:
        """
        典型动态规划解法
        时间复杂度：O(n)
        空间复杂度：O(n)
        :param prices: 价格列表，存储每天的价格
        :param fee: 交易手续费
        :return: 最大收益
        """
        if not prices:
            return 0
        n = len(prices)

        # 定义状态变量（两维， n*2）
        dp = [[0] * 2 for _ in range(n)]

        # dp[i][0] 表示第 i 天不持有股票时的最大收益
        # dp[i][1] 表示第 i 天持有股票时的最大收益
        # 设定在卖出时为完成一次交易，加 1 次交易次数
        dp[0][0], dp[0][1] = 0, -prices[0]
        for i in range(1, n):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])

        return dp[n - 1][0]

    def max_profit_optimize(self, prices: List[int], fee: int) -> int:
        """
        动态规划优化解法：状态变量复用，只用 2 * 2 二维数组存储状态即可，大幅降低内存消耗，适当提升性能
        时间复杂度：O(n)
        空间复杂度：O(1)
        :param prices: 价格列表，存储每天的价格
        :param fee: 交易手续费
        :return: 最大收益
        """
        if not prices:
            return 0
        n = len(prices)

        dp = [[0] * 2 for _ in range(2)]
        dp[0][0], dp[0][1] = 0, -prices[0]
        for i in range(1, n):
            j = i % 2
            k = (i - 1) % 2
            dp[j][0] = max(dp[k][0], dp[k][1] + prices[i] - fee)
            dp[j][1] = max(dp[k][1], dp[k][0] - prices[i])
        return dp[(n - 1) % 2][0]
