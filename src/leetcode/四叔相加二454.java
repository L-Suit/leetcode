package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 四叔相加二454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int count=0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                //存a+b的sum
                int sum = nums1[i] + nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for (int i = 0 ; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (map.containsKey(sum)){
                    count += map.get(sum);
                }
            }
        }

        return count;
    }
}
