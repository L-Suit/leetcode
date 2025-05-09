package leetcode.dp;

import java.util.Arrays;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++) {
                if (nums[i] >nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res =  Math.max(res, dp[i]);
        }

        return res ;
    }

}
