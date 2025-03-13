package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 赎金信383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //k-v，字符-出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //需要得到下标的遍历字符串
//        for (int i = 0; i < magazine.length(); i++){
//            char c = magazine.charAt(i);
//        }

        for (char c : ransomNote.toCharArray()){
            //池子里如果没有这个字符，返回false
            if (!map.containsKey(c)) return false;
            int count = map.get(c);
            //消耗一个
            count -= 1;
            if (count<0){
                return false;
            }else {
                map.put(c,count);
            }

        }

        return true;
    }
}
