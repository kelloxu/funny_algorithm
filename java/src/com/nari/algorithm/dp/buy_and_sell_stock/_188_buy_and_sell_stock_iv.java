package com.nari.algorithm.dp.buy_and_sell_stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Xu Jiong
 * Date: 2022/4/24 9:39
 * Description: 动态规划系列 —— 买卖股票4
 *              最多可以买卖 k 次
 *              手中最多可以持有一股，即如果手中有股票的话，要想再买，必须先卖出手中的股票
 */
public class _188_buy_and_sell_stock_iv {

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) return 0;
        int n = prices.length;  // 交易天数

        // 定义状态变量（三维）
        int[][][] dp = new int[n][k + 1][2];

        // 定义结果
        List<Integer> res = new ArrayList<>();

        if (k > n / 2) {
            //k = n / 2;
            return greedy(prices);
        }

        // 状态变量
        // dp[i][k][0] 表示第 i 天已交易 k 次时不持有股票时的最大收益
        // dp[i][k][1] 表示第 i 天已交易 k 次时持有股票时的最大收益
        // 设定：卖出股票时为完成一次交易，加一次交易次数

        // 状态初始化
        for (int kk = 0; kk <= k; kk++) {

            // 交易第一天，如果不持有股票，不管交易了多少次，收益均为 0
            dp[0][kk][0] = 0;

            // 交易第一天，如果持有股票，不管交易了多少次，收益均为第一天股价的负值
            dp[0][kk][1] = -prices[0];
        }

        // 状态转移方程
        // i = 0 时的状态，在状态初始化时已经处理，所以从 i = 1 时（即第二天交易）开始遍历，直到 i = n - 1（第 n 次交易）
        for (int i = 1; i < n; i++) {
            System.out.println("第 " + (i + 1) + "天交易");

            // 从第 0 次交易开始，直到第 k 次交易
            for (int j = 0; j <= k; j++) {
                System.out.println("   第 " + j  + "次交易");

                // 第 i + 1 天时，不持有股票时的最大收益 dp[i][j][0]，需要分情况讨论：
                // 1. 累计交易零次，前一天肯定也交易零次，并且肯定不持有股票
                if (j == 0) {
                    dp[i][j][0] = dp[i - 1][j][0];
                } else {

                    // 2. 累计交易次数不为零，此时不持有股票时的最大收益为：
                    //    max(前一天不持有股票、当天依然不买进股票的收益, 前一天持有股票、当天卖出股票的收益)
                    //    因为当天卖出股票，交易次数会加1，所以前一天的交易次数应该减1
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }

                // 持有股票时的最大收益 dp[i][j][1]，一个方程即可搞定：
                // max(前一天已经持有股票、当太不卖出的收益, 前一天没有股票、当天买入的收益)
                // 【注意】j = 0时，此方程依然适用：前一天第一次买入，当天不动，不算交易次数，交易次数依然为0；
                //                              之前没有操作过，当天第一次买入，不算交易次数，交易次数依然为0。
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        // 最后一天不持有股票的所有交易次数的收益的集合
        for (int m = 0; m <= k; m++) {
            res.add(dp[n - 1][m][0]);
        }

/*        for (int i = 0; i < n; i ++) {
            System.out.println();
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m < 2; m++) {
                    System.out.print(dp[i][j][m] + " ");
                }
            }
        }*/

        return Collections.max(res);
    }

    /**
     * 贪心算法
     *
     * @param prices 价格数组
     * @return 最大收益
     */
    public static int greedy(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, prices));
    }
}
