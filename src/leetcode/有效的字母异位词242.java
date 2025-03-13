package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 有效的字母异位词242 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap();


        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < t.length(); i++){
            Character ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
        }

        for (Character ch : map.keySet()){
            if (map.get(ch) != 0){
                return false;
            }
        }

        return true;
    }
}
