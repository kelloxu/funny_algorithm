package com.nari.algorithm;

import java.util.List;

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
