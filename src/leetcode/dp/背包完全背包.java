package leetcode.dp;

import java.util.Scanner;

public class 背包完全背包 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int  n  = sc.nextInt();
        int  bagSize  = sc.nextInt();

        int [] weight = new int[n];
        int [] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int [][] dp = new int[n][bagSize+1];

        //初始化
        for (int i = weight[0]; i <=bagSize; i++) {
            dp[0][i] = dp[0][i-weight[0]] + value[0];
        }

        //遍历
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <=bagSize ; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j]; //二维dp需要这个，一维的话就直接continue就可以
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]] + value[i]);
                }

            }
        }

        System.out.println(dp[n-1][bagSize]);
    }
}
