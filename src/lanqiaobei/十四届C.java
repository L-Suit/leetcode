package lanqiaobei;

import java.util.Scanner;

public class 十四届C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            //给区域格子取反
            for (int j = x1 - 1; j < x2; j++) {
                for (int k = y1 - 1; k < y2; k++) {
                    //三元表达式
                    if (arr[j][k] == 0){
                        arr[j][k] = 1;
                    }else {
                        arr[j][k] = 0;
                    }
                    //arr[j][k] = (arr[j][k] == 0 ? 1 : 0);
                }
            }
        }

        //输出数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            if (i != n - 1){
                System.out.println();
            }
        }
    }

}
