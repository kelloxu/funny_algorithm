from typing import List

"""
题目地址：https://leetcode-cn.com/problems/3sum/
题目概述：Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
        and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/3sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
解体思路：排序 + 一次遍历 + 双指针
重点技巧：排过序后，相同的元素都在一起了，去重就更好处理了
"""


def three_sum(nums: List[int]) -> List[List[int]]:
    res = []
    if len(nums) < 3: return res
    nums.sort()  # 排序
    print(nums)
    for k in range(len(nums) - 2):  # 遍历，因为至少要留两个位置给i和j，所以遍历的长度为 len(nums) - 2
        print("--- k = ", k)
        if nums[k] > 0: break  # 数组已排过序，如果第一个元素就大于零，那么不能再后面的元素出找到和等于零的数。
        if k > 0 and nums[k] == nums[k - 1]: continue  # 首先考虑去重
        i, j = k + 1, len(nums) - 1  # 最后一个元素的索引为 len(nums) - 1
        while i < j:
            print("------- nums[{0}] = {1}, nums[{2}] = {3}, nums[{4}] = {5}".format(k, nums[k], i, nums[i], j, nums[j]))
            s = nums[k] + nums[i] + nums[j]
            print("------- s = ", s)
            if s < 0:
                i += 1
                while i < j and nums[i] == nums[i - 1]: i += 1  # 继续去重
            elif s > 0:
                j -= 1
                while i < j and nums[j] == nums[j + 1]: j -= 1  # 继续去重
            else:  # 找到和等于零的三个数
                res.append([nums[k], nums[i], nums[j]])
                i += 1
                j -= 1
                while i < j and nums[i] == nums[i - 1]: i += 1  # 继续去重
                while i < j and nums[j] == nums[j + 1]: j -= 1  # 继续去重
    return res


def main():
    nums = [5, -3, 1, 7, -2, 9, -1, -1, 0, 4, -8, -2, 0, -2, 3, -5, 0]
    print(three_sum(nums))


if __name__ == '__main__':
    main()
