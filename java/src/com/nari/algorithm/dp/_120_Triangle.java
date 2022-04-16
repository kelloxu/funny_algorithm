package com.nari.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

/*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
*/
public class _120_Triangle {

    public static int minimumSum(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        int len = triangle.size();
        List<Integer> res = triangle.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= triangle.get(i).size() - 1; j++) {
                int ijState = min(res.get(j), res.get(j + 1)) + triangle.get(i).get(j);
                res.set(j, ijState);
            }
        }
        return res.get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(6, 5, 4));
        triangle.add(Arrays.asList(4, 1, 100, 101));
        System.out.println(minimumSum(triangle));
    }
}
