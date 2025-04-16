package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);

        return ans;
    }

    private void backtrack(String s, int index) {
        if (index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        //剪枝

        for (int i = index; i < s.length(); i++) {
            String x = s.substring(index,i+1);
            if (!isHuiwen(x)){
                continue;
            }
            path.add(x);
            backtrack(s,i+1);
            path.remove(path.size()-1);
        }
    }

    private boolean isHuiwen(String s) {
        if (s.length() == 1) return true;

        for (int i = 0; i < s.length()/2; i++) {
            if (! (s.charAt(i) == (s.charAt(s.length()-i-1)))){
                return false;
            }
        }

        return true;
    }


}
