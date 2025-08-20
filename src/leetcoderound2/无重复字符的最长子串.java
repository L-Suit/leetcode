package leetcoderound2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lishihao
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        char [] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLen =0;
        int r=0;

        for (int i = 0; i < chars.length; i++) {
            if (i !=0){
                set.remove(chars[i-1]);
            }

            while (r<chars.length && !set.contains(chars[r])){
                set.add(chars[r]);
                r++;
            }
            maxLen = Math.max(maxLen,r-i);
        }

        return maxLen;
    }
}
