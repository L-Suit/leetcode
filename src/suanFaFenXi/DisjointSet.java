package suanFaFenXi;

import java.util.*;

public class DisjointSet {
    // 对于一个正整数n，它表示0~n-1这n个元素，每个pair中的两个元素取自这n个元素。
    // 返回的二位数组中，每一维表示一个集合，其中的元素序号从小到大排列
    // 一维数组之间按照字典序从小到大排列。
    public static int[][] disjointSearch(int n, Pair[] pairs) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        //nums数组的值表示组号
        int [] nums = new int[n];
        int x,y;
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        for (Pair p:pairs) {
            //如果不在一个集合中，合并
            if (!isConnected(nums,p.x,p.y)){
                int xzuHao = nums[p.x];
                int yzuHao = nums[p.y];
                //把y所在组的所有元素组号改为x的
                for (int i=0;i<n;i++){
                    if (nums[i]==yzuHao){
                        nums[i]=xzuHao;
                    }
                }

            }
        }

        //借助hashmap存储
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }


        Integer [] keys = new Integer[map.size()];
        keys = map.keySet().toArray(keys);
        int [][] ans = new int[keys.length][];

        for (int i = 0; i < keys.length; i++) {
            List<Integer> list = map.get(keys[i]);
            ans[i] = list.stream().mapToInt(Integer::valueOf).toArray();
        }
        return ans;
    }

    public static boolean isConnected(int [] nums,int x,int y){
        if (x==y) return true;
        if (nums[x]==nums[y]) return true;
        return false;
    }
}
