package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 快乐数202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        while (true){
            sum = getSum(n);
            if (sum == 1){
                return true;
            }
            if (set.contains(sum)){
                return false;
            }else {
                set.add(sum);
            }
            n = sum;
        }
    }

    private int getSum(int n) {
        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++){
            Character c = num.charAt(i);
            int number = Integer.valueOf(c.toString());
            sum += number * number;
        }

        return sum;
    }
}
