package leetcode.dp;

public class 零钱兑换2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        //初始化
        dp[0] =1;



        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount+1; j++) {
               dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        return dp[amount];
    }
}
