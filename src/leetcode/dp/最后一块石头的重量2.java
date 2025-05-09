package leetcode.dp;

public class 最后一块石头的重量2 {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length ==1) return stones[0];
        int sum = 0;

        int len = stones.length;

        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        //初始化
        int[] dp = new int[sum/2 +1];

        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            for (int j = sum/2; j >0; j--) {
                if (j-stones[i]<0) continue;
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        int x = dp[sum/2];
        int y = sum-x;

        return Math.abs(x-y);
    }
}
