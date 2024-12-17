package leetcode;

import java.util.Arrays;

public class 二分查找704 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 5, 6, 7, 4, 9,34,51,56};
        Arrays.sort(nums);

        int target = 8;

        Solution s = new Solution();
        int ans = s.search(nums, target);
        System.out.println(ans);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0,right = len-1;
            int mid = 0;
            while (left<=right){
                mid = (left+right)/2;  //向下取整
                if (nums[mid]==target){
                    return mid;
                }
                if (nums[mid]>target){//mid值大于target
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }

            return -1;
        }
    }
}
