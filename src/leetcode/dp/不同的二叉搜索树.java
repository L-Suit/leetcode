package leetcode.dp;

public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n<2) return n;
        int[] dp = new int[n+1];

        dp[0] =1;
        dp[1] =1;

        for (int i = 2; i <=n ; i++) {
            //每个dp[i]等于遍历相加
            int sum =0;
            for (int j = 0; j <i ; j++) {
                sum = sum + dp[j] * dp[i-j-1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = new 不同的二叉搜索树().numTrees(3);
    }
}
