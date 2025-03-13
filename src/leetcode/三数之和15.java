package leetcode;

import java.util.*;

public class 三数之和15 {
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //数组中元素-下标
        Map<Integer, Integer> map = new HashMap<>();

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (map.containsKey(-sum)){
                    //判断下标是否相等
                    int index = map.get(-sum);
                    if (index > j && index != i && index != j){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[index]);
                        list.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1 - o2;
                            }
                        });
                        set.add(list);
                    }

                }

            }
        }

        for (List<Integer> list : set){
            res.add(list);
        }

        return res;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            //去重
            if (i>0 && nums[i]==nums[i-1]) continue;
            l = i + 1;
            r = nums.length - 1;
            while (l != r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    while (r > l && nums[l] == nums[l + 1]) l++;
                    r--;
                    l++;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }

            }

        }

        return res;
    }
}
