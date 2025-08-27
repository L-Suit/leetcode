package leetcode.linklist;

import java.util.Arrays;
import java.util.Comparator;

public class 移除元素27 {
    public static void main(String[] args) {
        int[] nums = {-2,-5,3,1,2,-4,3};
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(array,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int val = 3;

        int ans = new 移除元素27().removeElement(nums, val);
        for (Integer i: array){
            System.out.println(i);
        }
        System.out.println(array);
    }

    public int removeElement0(int[] nums, int val) {
        if (nums.length==0) {
            return 0;
        }
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
    public int removeElement(int[] nums, int val) {
        int count =0;
        int l=0;
        int r=0,len = nums.length;

        while (r < len){
            while (r <len && nums[r] == val){
                r ++;
            }
            if (r ==len){
                break;
            }
            nums[l] = nums[r];
            count++;
            l++;
            r++;
        }



        return count;
    }
}
