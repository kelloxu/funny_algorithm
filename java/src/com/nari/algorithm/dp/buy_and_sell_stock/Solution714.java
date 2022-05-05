package com.nari.algorithm.dp.buy_and_sell_stock;

/**
 * Author: Xu Jiong
 * Date: 2022/5/5 19:26
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 题目描述：
 *          动态规划系列 —— 买卖股票
 *          股价不小于1： 1 <= prices[i] <= 50000
 *          不限次数买卖
 *          每次交易有手续费: 0 <= fee <= 50000
 */
public class Solution714 {

    /**
     * 动态规划优化算法：
     *                 状态变量复用，只用 2 * 2 二维数组存储状态，大幅降低内存消耗，适当提升性能
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param prices 价格数组
     * @param fee 交易手续费
     * @return 最大收益
     */
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // 定义状态变量
        int[][] dp = new int[2][2];

        // 初始话状态变量
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 状态方程
        for (int i = 1; i < n; i++) {
            int k = i % 2;
            int l = (i - 1) % 2;
            dp[k][0] = Math.max(dp[l][0], dp[l][1] + prices[i] - fee);
            dp[k][1] = Math.max(dp[l][1], dp[l][0] - prices[i]);
        }

        return dp[(n - 1) % 2][0];
    }

    public static void main(String[] args) {
        int fee = 2;
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices, fee));
    }
}
