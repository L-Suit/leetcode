package leetcode.dp;

import java.util.Scanner;

public class 背包01背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[m][n+1];
        int[] weight = new int[m];
        int[] val = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            val[i] = sc.nextInt();
        }

        //dp初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] =0;
        }
        for (int i = 0; i <=n; i++) {
            if (i>=weight[0]){
                dp[0][i] = val[0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <=n; j++) {
                //放不下 直接只有不放的选择
                if (j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else dp[i][j] =Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+val[i] );
            }
        }
        System.out.println(dp[m-1][n]);
    }
}
