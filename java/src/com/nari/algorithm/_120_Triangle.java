package com.nari.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

/*
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
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(6, 5, 4));
        triangle.add(Arrays.asList(4, 1, 100, 101));
        System.out.println(minimumSum(triangle));
    }
}
