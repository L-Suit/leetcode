package leetcode.dp;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int [] dp = new int[len];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
