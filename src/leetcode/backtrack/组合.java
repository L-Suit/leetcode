package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        backtrack(n, k,0);
        return ans;
     }

    private void backtrack(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() ==k){
            ans.add(new ArrayList<>(path));
            return;
        }

        //遍历，从startIndex开始遍历到最后
        for (int i = startIndex; i <=n; i++) {
            path.add(i);
            backtrack(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
