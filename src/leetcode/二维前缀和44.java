package leetcode;

import java.util.Scanner;

public class 二维前缀和44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int preNumsSum[][] = new int[n][m];
        int num,minChange = Integer.MAX_VALUE;
        int sum1,sum2;

        //二维前缀和初始化
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++){
                num = sc.nextInt();
                if (i==0 && j==0) {
                    preNumsSum[0][0] = num;
                    continue;
                }
                if (i==0){//第一行
                    preNumsSum[i][j] = preNumsSum[i][j-1] + num;
                    continue;
                }
                if (j==0){//第一列
                    preNumsSum[i][j] = preNumsSum[i-1][j] + num;
                    continue;
                }
                preNumsSum[i][j] = preNumsSum[i][j-1] + preNumsSum[i-1][j] - preNumsSum[i-1][j-1] + num;

            }
        //遍历所有划分情况
        //按所有行划分
        for (int i = 0; i < n-1; i++) {
            sum1 = preNumsSum[i][m-1];
            sum2 = preNumsSum[n-1][m-1] - sum1;
            minChange = Math.min(minChange,Math.abs(sum1-sum2));
        }

        //按所有列划分
        for (int j = 0; j < m-1; j++) {
            sum1 = preNumsSum[n-1][j];
            sum2 = preNumsSum[n-1][m-1] - sum1;
            minChange = Math.min(minChange,Math.abs(sum1-sum2));
        }
        System.out.println(minChange);
    }
}
