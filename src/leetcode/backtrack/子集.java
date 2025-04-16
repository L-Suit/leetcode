package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return ans;
    }

    private void backtrack(int[] nums, int index) {
        ans.add(new ArrayList<>(path));
        //跳出
        if (index > nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.remove(path.size()-1);
        }

    }
}
