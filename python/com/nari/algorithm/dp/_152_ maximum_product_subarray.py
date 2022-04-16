"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray/
"""

from typing import List


def max_product(nums: List[int]) -> int:
    """
    使用动态规划求解
    状态量为二维数组
    :param nums: 整形数组
    :return: 最大乘积
    """

    if nums is None:
        return 0

    # 创建初始值为 0 的 2x2 数组，存每一步的状态值
    dp = [[0 for _ in range(2)] for _ in range(2)]

    # 给状态变量、最终结果赋初始值
    dp[0][0], dp[0][1], res = nums[0], nums[0], nums[0]

    for i in range(1, len(nums)):
        x, y = i % 2, (i - 1) % 2

        # 状态转移方程
        dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
        dp[x][1] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])

        res = max(dp[x][0], res)

    return res


def main():
    nums = [2, 3, -2, 4]
    print(max_product(nums))


if __name__ == '__main__':
    main()
