package leetcode.dp;

public class 组合总和4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        //初始化
        dp[0] =1;


        for (int j = 1; j < target+1; j++) {
            for (int i = 0; i <nums.length ; i++) {
                if (j < nums[i]){
                    continue;
                }
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
