package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class 复原ip地址 {
    private Set<String> ans = new HashSet<>();
    List<String> path = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        List<String> ans1 = new ArrayList<>();
        for (String s1 : ans){
            System.out.println(s1);
            ans1.add(s1);
        }
        return ans1;
    }

    private void backtrack(String s, int index) {
        int len = s.length();
        //判断跳出
        if (index >len) return;


        if (path.size() == 4){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                sb.append(path.get(i));
                sb.append(".");
            }
            sb.append(path.get(path.size()-1));
            ans.add(sb.toString());
            return;
        }

        for (int i = index; i < len; i++) {
            String x;
            if (path.size()==3 && i < len - 1){
                x = s.substring(index, len);
            }else {
                x = s.substring(index, i + 1);
            }

            //判断剪枝,子串满足0-255
            if (x.charAt(0) == '0' && x.length() > 1){
                continue;
            }
            if (Long.valueOf(x) >255 || x.length() > 3){
                break;
            }

            path.add(x);
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        复原ip地址 a = new 复原ip地址();
        List<String> ans = a.restoreIpAddresses("25525511135");

        ans.toArray(new String[0]);
    }


}
