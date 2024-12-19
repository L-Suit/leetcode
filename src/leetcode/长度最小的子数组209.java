package leetcode;

public class 长度最小的子数组209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int ans = minSubArrayLen(7,nums);
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,sum=nums[0];
        int len =  nums.length;
        int low = Integer.MAX_VALUE,flag=0;

        while (r<len) {//跳出条件
            while (sum < target) {//向右移动r直到sum大于等于tar
                if (r ==len-1) {
                    if (flag==0) return 0;
                    else return low;
                }
                r++;
                sum += nums[r];
            }
            while (sum >= target){//向右移动l，直到sum刚好不满足大于等于tar
                if (sum >= target){//更新最小值
                    flag =1;
                    low = Math.min(low,r-l+1);
                }

                sum -= nums[l];
                l++;
            }
        }
        if (flag==0) return 0;
        else return low;

    }
}
