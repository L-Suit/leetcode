package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    //找出1-9数字中，和为n的k个数所有组合
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack3(k, n, 1,0);
        return ans;
    }

    private void backtrack3(int k, int targetSum, int index,int sum) {
        // 终止条件
        if (path.size() == k && sum == targetSum){
            ans.add(new ArrayList<>(path));
            return;
        }

        //剪枝
        if (9-index < k-path.size()){
            return;
        }

        // 遍历，从startIndex开始遍历到最后
        for (int i = index; i <= 9; i++) {
            path.add(i);
            backtrack3(k,targetSum,i+1,sum+i);
            path.remove(path.size()-1);
        }
    }

    /*给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
    找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    同一个 数字可以 无限制重复被选取*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target,0,0);

        return ans;
    }

    private void backtrack(int[] candidates, int targetSum, int index, int sum) {
        // 终止条件
        if (sum == targetSum){
            ans.add(new ArrayList<>(path));
            return;
        }

        //剪枝
        if (sum > targetSum){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates,targetSum,i,sum);
            path.remove(path.size()-1);
            sum -= candidates[i];
        }
    }

    /*给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack2(candidates,target,0,0,used);
        return ans;
    }

    private void backtrack2(int[] candidates, int targetSum, int index, int sum,boolean[] used) {
        if (sum == targetSum){
            ans.add(new ArrayList<>(path));
            return;
        }

        //剪枝
        if (sum>targetSum){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i>0 && candidates[i]==candidates[i-1] && !used[i-1]){
                continue;//去重
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtrack2(candidates,targetSum,i+1,sum,used);
            path.remove(path.size()-1);
            sum -= candidates[i];
            used[i] = false;
        }
    }

}
