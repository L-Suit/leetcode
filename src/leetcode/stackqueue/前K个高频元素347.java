package leetcode.stackqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素347 {

    public static void main(String[] args) {
        前K个高频元素347 a = new 前K个高频元素347();
        int[] num= new int[]{1,1,1,2,2,3};
        int[] ints = a.topKFrequent(num, 2);
        System.out.println(1);
    }
    public int[] topKFrequent0(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare( int[] o1, int[] o2){
                return o1[1]-o2[1];//队头到队尾升序，小根堆
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>(); // number-count

        for (int num: nums) {//getordefalt
/*            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }*/
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (int num:map.keySet()) {
            int[] temp = new int[2];
            temp[0] = num;
            temp[1] = map.get(num);

            //送入优先队列
            if (queue.size()<k){
                queue.offer(temp);
            }else {
                if (temp[1] >= queue.peek()[1]){
                    queue.poll();
                    queue.offer(temp);
                }
            }
        }

        // 返回结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k-i-1] = queue.poll()[0];
        }


        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<int []> queue = new PriorityQueue(k, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Map<Integer,Integer> mapCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            mapCount.put(num,mapCount.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry : mapCount.entrySet()){
            int[] a = new int[2];
            a[0] = entry.getKey();
            a[1] = entry.getValue();
            if (queue.size()<k){
                queue.offer(a);
            }else{
                if (!queue.isEmpty() && a[1] > queue.peek()[1]){
                    queue.poll();
                    queue.offer(a);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }


        return ans;
    }
}
