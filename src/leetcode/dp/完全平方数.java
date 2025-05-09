package leetcode.dp;

public class 完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        for (int i = 0; i <dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        int [] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (i+1)*(i+1);
        }

        //初始化
        dp[0] =0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <=n; j++) {
                if (dp[j-nums[i]] == Integer.MAX_VALUE){
                    continue;
                }
                dp[j] = Math.min(dp[j],dp[j-nums[i]]+1);
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
