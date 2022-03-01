import java.util.*;

/**
 * 题目地址：https://leetcode-cn.com/problems/3sum/
 * 题目概述：Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 *         and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *         Notice that the solution set must not contain duplicate triplets.
 *
 *          来源：力扣（LeetCode）
 *          链接：https://leetcode-cn.com/problems/3sum
 *          著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_3sum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return  res;
        }
        Arrays.sort(nums);  // 排序
        System.out.println(Arrays.toString(nums));

        for (int k = 0; k < nums.length - 2 ; k++) {  // 一次遍历
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) continue;  // 去重
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s < 0) {
                    i += 1;
                    while (i < j && nums[i] == nums[i - 1]) i += 1;  // 去重
                } else if (s > 0) {
                    j -= 1;
                    while (i < j && nums[j] == nums[j + 1]) j -= 1;  // 去重
                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i += 1;
                    j -= 1;
                    while (i < j && nums[i] == nums[i - 1]) i += 1;  // 去重
                    while (i < j && nums[j] == nums[j + 1]) j -= 1;  // 去重
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, -3, 1, 7, -2, 9, -1, -1, 0, 4, -8, -2, 0, -2, 3, -5, 0};
        _15_3sum _3sum = new _15_3sum();
        System.out.println(_3sum.threeSum(nums));
    }
}
