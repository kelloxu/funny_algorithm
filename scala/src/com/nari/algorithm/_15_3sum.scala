package com.nari.algorithm

/**
 * 题目地址：https://leetcode-cn.com/problems/3sum/
 * 题目概述：Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k] ] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object _15_3sum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {

    var res: List[List[Int]] = List()
    if (nums.length < 3) {
      return res
    }

    val numsSorted = nums.sorted
    println(numsSorted.mkString(","))

    for (k <- 0 until numsSorted.length - 2) {
      if (numsSorted(k) > 0) return res  // 使用 return 代替 break
      if (!(k > 0 && numsSorted(k) == numsSorted(k - 1))) {  // 使用 if 代替 continue
        var i = k + 1
        var j = numsSorted.length - 1
        while (i < j) {
          val s = numsSorted(k) + numsSorted(i) + numsSorted(j)
          if (s < 0) {
            i += 1
            while (i < j && numsSorted(i) == numsSorted(i - 1)) i += 1
          } else if (s > 0) {
            j -= 1
            while (i < j && numsSorted(j) == numsSorted(j + 1)) j -= 1
          } else {
            res = res :+ List(numsSorted(k), numsSorted(i), numsSorted(j))
            i += 1
            j -= 1
            while (i < j && numsSorted(i) == numsSorted(i - 1)) i += 1
          }
        }
      }
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(5, -3, 1, 7, -2, 9, -1, -1, 0, 4, -8, -2, 0, -2, 3, -5, 0)
    println(threeSum(nums))
  }
}
