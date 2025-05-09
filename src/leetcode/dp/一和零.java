package leetcode.dp;

public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];

        //初始化
        dp[0][0] = 0;

        for (int k = 0; k < strs.length; k++) {//物品
            int count0 = 0;
            int count1 = 0;

            String str = strs[k];
            //计算0和1的个数
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0'){
                    count0++;
                }else {
                    count1++;
                }
            }

            for (int i = m; i >=0 ; i--) {
                for (int j = n; j >=0 ; j--) {
                    if (i < count0 || j < count1){
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j],dp[i-count0][j-count1] +1);
                }
            }

        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(new 一和零().findMaxForm(strs, m, n));
    }
}
