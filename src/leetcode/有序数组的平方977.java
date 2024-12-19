package leetcode;

import java.util.Arrays;

public class 有序数组的平方977 {
    public static void main(String[] args) {

        int ans[] = sortedSquares(new int[]{-7,-3,2,3,11});
        for(int i:ans){
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int lowAbs = Integer.MAX_VALUE;
        int index = 0, left, right,ansIndex=0;
        for(int i=0;i<nums.length;i++){//找到最接近0的位置
            if (Math.abs(nums[i]) < lowAbs){
                lowAbs = Math.abs(nums[i]);
                index = i;
            }
        }

        left = index-1;
        right = index+1;
        ans[ansIndex++] = nums[index]*nums[index];//处理第一个元素


        while (left >= 0 && right < nums.length){  //有一个不满足就跳出，后续处理一边剩余的
            if (Math.abs(nums[left]) <= Math.abs(nums[right])){
                ans[ansIndex++] = nums[left]*nums[left];
                left--;
            }else {
                ans[ansIndex++] = nums[right]*nums[right];
                right++;
            }
        }


        //处理一边剩余的
        while (left>=0){
            ans[ansIndex++] = nums[left]*nums[left];
            left--;
        }

        while (right<nums.length){
            ans[ansIndex++] = nums[right]*nums[right];
            right++;
        }

        return ans;
    }
}
