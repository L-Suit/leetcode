package leetcode.dp;

public class 分割等和子集 {
    //回溯法 超时
    /*public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n:  nums) {
            sum += n;
        }
        if (sum%2!=0) return false;
        int target = sum/2;

        return backtrack(nums,0,0,target);
    }

    private boolean backtrack(int[] nums, int index, int sum,int target) {
        if (sum == target) return true;
        if (index ==nums.length) return false;

        for (int i = index; i <nums.length; i++) {
            //剪枝
            if (sum+nums[i]>target) continue;
            sum += nums[i];
            if (backtrack(nums,i+1,sum,target)== true){
                return true;
            }
            sum -= nums[i];
        }
        return false;
    }*/

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int[] dp = new int[target + 1];

        //初始化
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >=0 ; j--) {
                if (j-nums[i]<0) continue;
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                if (dp[j] == target) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new 分割等和子集().canPartition(nums));
    }
}
