package leetcode;

import java.util.*;

public class 两个数组的交集34 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans = new 两个数组的交集34().intersection(nums1, nums2);
    }
    public int[] intersection0(int[] nums1, int[] nums2) {
        Set<Integer> ansSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for(Integer num : nums1){
            set.add(num);
        }

        for (Integer num : set){
            System.out.println(num);
        }

        for (Integer num : nums2){
            if (set.contains(num)){
                ansSet.add(num);
            }
        }

        int [] ans = ansSet.stream().mapToInt(Integer::intValue).toArray();

        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int [] ans = null;
        List<Integer> ansList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            set.add(num);
        }

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (set.contains(num)){
                ansSet.add(num);
            }
        }

        for (Integer num : ansSet){
            ansList.add(num);
        }

        ans = ansList.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}
