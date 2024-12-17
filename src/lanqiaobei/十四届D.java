package lanqiaobei;

import java.util.Scanner;

/*给定一个 n × m （n 行 m 列）的矩阵。
设一个矩阵的价值为其所有数中的最大值和最小值的乘积。求给定矩阵的所有大小为 a × b （a 行 b 列）的子矩阵的价值的和。
答案可能很大，你只需要输出答案对 998244353 取模后的结果。
输入格式
输入的第一行包含四个整数分别表示 n, m, a, b ，相邻整数之间使用一个空格分隔。
接下来 n 行每行包含 m 个整数，相邻整数之间使用一个空格分隔，表示矩阵中的每个数 Ai, j 。*/
public class 十四届D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 0,max,min;
        //输入矩阵
        int [][]arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 选择窗口的左上角
        for (int i = 0; i <=n-a; i++) {
            for (int j = 0; j <= m-b; j++) {
                //求每个窗口的矩阵的价值
                max=Integer.MIN_VALUE;
                min=Integer.MAX_VALUE;
                for (int k = i; k < i+a; k++) {
                    for (int l = j; l < j+b; l++) {
                        max = Math.max(max,arr[k][l]);
                        min = Math.min(min,arr[k][l]);
                    }
                }
                ans += (max*min)%998244353;
                ans %=998244353;
            }
        }

        System.out.println(ans);

    }
}
