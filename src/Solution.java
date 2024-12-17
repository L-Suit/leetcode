import java.util.*;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int max = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        dp[0] =0;
        //遍历背包
        for (int i = 1; i <=n; i++) {
            //遍历物品
            for (int j = 1; j*j <=i ; j++) {
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n-1];
    }
}
