"""
 题目概述：You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
         On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
         at any time. However, you can buy it then immediately sell it on the same day.
         Find and return the maximum profit you can achieve.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

from typing import List


def max_profit(prices: List[int]):
    """本题没有手续费、不限交易次数，可以使用贪心算法"""
    max_value = 0
    for i in range(len(prices) - 1):
        if prices[i] < prices[i + 1]:
            max_value += prices[i + 1] - prices[i]
    return max_value


def main():
    prices = [7, 1, 5, 3, 6, 4]
    print(max_profit(prices))


if __name__ == '__main__':
    main()
