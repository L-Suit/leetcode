package leetcode.stackqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 前K个高频元素347 {
    public int[] topKFrequent(int[] nums, int k) {
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
}
