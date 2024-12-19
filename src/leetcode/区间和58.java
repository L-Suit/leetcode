package leetcode;

import java.util.Scanner;

/**
 * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
输入描述
第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），
直至文件结束。

时间有限制，考虑前缀和，
 */

public class 区间和58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[]  preSum= new int[n];
        int a,b,sum=0,ans;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //初始换前缀和
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i-1];
        }


        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            if (a==0){
                ans = preSum[b];
            }else {
                ans = preSum[b] -preSum[a-1];
            }

            System.out.println(ans);
        }

    }


}
