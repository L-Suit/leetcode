package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
