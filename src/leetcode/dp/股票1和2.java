package leetcode.dp;

public class 股票1和2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[2];
        dp[1] = 0;
        dp[0] = -prices[0];


        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0] ,dp[1]-prices[i]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i]);
        }

        return dp[1];
    }
}
