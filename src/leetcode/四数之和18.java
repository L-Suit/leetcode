package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2 ; j++) {
                int sum12=nums[i]+nums[j];
                //重点语句，易错！！
                if (sum12>target && nums[j] + nums[i] >= 0){
                    break;
                }
                if (j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int l = j+1;
                int r = nums.length-1;

                while (l<r){
                    int sumAll = sum12+nums[l]+nums[r];
                    if (sumAll == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        //去重
                        while (l<r && nums[r-1]==nums[r]) r--;
                        while (l<r && nums[l+1]==nums[l]) l++;
                        l++;
                        r--;
                    }else if (sumAll<target){
                        l++;
                    }else {
                        r--;
                    }

                }

            }

        }


        return res;
    }
}
