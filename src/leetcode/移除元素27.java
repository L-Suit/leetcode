package leetcode;

import java.util.Arrays;

public class 移除元素27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};

        int val = 3;

        int ans = new 移除元素27().removeElement(nums, val);
        System.out.println(ans);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length==0) return 0;
        int l=0,r=0;
        int len = nums.length;
        while (r<len){
            while (nums[r]==val){   //找到不为val的r
                if (r==len-1){
                    return l;    //说明没有可替换元素
                }r++;
            }

            nums[l] = nums[r]; //替换
            l++;
            r++;
        }
        return l;
    }
}
