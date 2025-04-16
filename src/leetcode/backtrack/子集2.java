package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集2 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums,0,used);
        return ans;
    }

    private void backtrack(int[] nums, int index,boolean[] used) {
        ans.add(new ArrayList<>(path));
        //跳出
        if (index > nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            //去重
            if (i>0 && nums[i]==nums[i-1] && used[i-1]==false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,i+1,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
