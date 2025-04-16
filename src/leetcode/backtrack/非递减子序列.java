package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 非递减子序列 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrape(nums,0,-200);
        return ans;
    }

    private void backtrape(int[] nums, int index,int max) {
        //path判断加ans
        if (path.size()>=2){
            ans.add(new ArrayList<>(path));
        }

        // 跳出条件
        if (index>=nums.length){
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++){
            //筛选下能加入路径的点
            if (nums[i] < max){
                continue;
            }
            //去重
            if (set.contains(nums[i])){
                continue;
            }else {
                set.add(nums[i]);
            }

            path.add(nums[i]);
            backtrape(nums,i+1,nums[i]);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,1,1,1,1};
        List<List<Integer>> subsequences = new 非递减子序列().findSubsequences(nums);
        for (List<Integer> list : subsequences) {
            System.out.println(list);
        }
    }
}
