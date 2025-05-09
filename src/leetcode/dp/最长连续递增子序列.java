package leetcode.dp;

import java.util.Arrays;

public class 最长连续递增子序列 {
    public int findLengthOfLCIS(int[] nums) {
        int [] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] +1;
            }else dp[i] = 1;

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
