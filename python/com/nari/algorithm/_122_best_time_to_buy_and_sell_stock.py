"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
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
