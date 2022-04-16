"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
"""

from typing import List


def minimum_sum(triangle: List[List[int]]) -> int:
    """使用动态规划求解"""
    if not triangle:
        return 0
    res = triangle[-1]
    for i in range(len(triangle) - 2, -1, -1):
        for j in range(len(triangle[i])):
            res[j] = triangle[i][j] + min(res[j], res[j + 1])
    return res[0]


def main():
    triangle = [[2], [3, 2], [6, 5, 4], [4, 1, 100, 101]]
    print(minimum_sum(triangle))


if __name__ == '__main__':
    main()
