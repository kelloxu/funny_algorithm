package com.nari.algorithm;

import java.util.List;

/*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
public class _122_BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxValue = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxValue += prices[i + 1] - prices[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
