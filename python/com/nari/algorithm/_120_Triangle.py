"""
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
