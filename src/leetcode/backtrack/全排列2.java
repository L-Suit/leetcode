package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used);
        return ans;
    }


    private void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){continue;}
            //去重
            if (i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
