"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
"""

from typing import List


class Solution:

    def max_profit(self, k: int, prices: List[int]) -> int:
        if not prices or not k:
            return 0
        n = len(prices)  # 交易天数

        # 当k大于数组长度的一半时，等同于不限次数交易即122题，用贪心算法解决，否则LeetCode会超时，
        # 也可以直接把超大的k替换为数组的一半，就不用写额外的贪心算法函数
        if k > n // 2:
            return self.greedy(prices)
            # k = n // 2

        # 定义状态变量（三维）和结果变量
        dp, res = [[[0] * 2 for _ in range(k + 1)] for _ in range(n)], []

        # dp[i][k][0] 表示第 i 天已交易 k 次时不持有股票时的最大收益
        # dp[i][k][1] 表示第 i 天已交易 k 次时持有股票是的最大收益
        # 设定在卖出时为完成一次交易，加 1 次交易次数
        for i in range(k + 1):
            # 第一天，如果不持有股票，不管交易多少次，收益均为 0
            # 如果持有股票，不管交易多少次，收益均为 - prices[0]
            dp[0][i][0], dp[0][i][1] = 0, - prices[0]
        for i in range(1, n):
            for j in range(k + 1):
                if not j:
                    dp[i][j][0] = dp[i - 1][j][0]
                else:
                    dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i])
                dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i])

        # 所有交易次数最有一天不持有股票的集合的最大值即为问题的解
        for m in range(k + 1):
            res.append(dp[n - 1][m][0])
        return max(res)

    # 处理k过大导致超时的问题，用贪心解决
    def greedy(self, prices):
        res = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                res += prices[i] - prices[i - 1]
        return res
