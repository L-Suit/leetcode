package leetcode.dp;

public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n<3) return n;
        int[] dp = new int[n];
        int  t1 = 1;
        int t2 = 2;
        int ans= 0;

        for (int i = 3; i <=n ; i++) {
            ans = t1+t2;
            t1 = t2;
            t2 = ans;
        }

        return ans;
    }
}
