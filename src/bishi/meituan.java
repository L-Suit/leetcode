package bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class meituan {
    //04.19笔试
    //1.整数转变
    // 定义状态类：记录当前值和当前的总花费
    static class State implements Comparable<State> {
        long val;   // 当前的数值
        int cost;   // 当前到达这个值的总花费

        public State(long val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        // 为了能放入优先队列，按花费升序排序
        public int compareTo(State other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    // 主函数：计算从n变到不小于m的最小花费
    public static int minCost(long n, long m, int w2, int w3) {
        // 优先队列（小根堆）：总是扩展当前最小花费的路径
        Queue<State> pq = new PriorityQueue<>();

        // 用来记录已经访问过的值，避免重复访问
        Set<Long> visited = new HashSet<>();

        // 初始状态入队：值是n，花费是0
        pq.add(new State(n, 0));
        visited.add(n);

        while (!pq.isEmpty()) {
            State cur = pq.poll(); // 取出花费最小的状态

            // 如果当前值已经大于等于目标m，直接返回最小花费
            if (cur.val >= m) {
                return cur.cost;
            }

            // 尝试操作1：乘以2
            long next2 = cur.val * 2;
            if (!visited.contains(next2)) {
                pq.add(new State(next2, cur.cost + w2)); // 入队新状态
                visited.add(next2);
            }

            // 尝试操作2：乘以3
            long next3 = cur.val * 3;
            if (!visited.contains(next3)) {
                pq.add(new State(next3, cur.cost + w3)); // 入队新状态
                visited.add(next3);
            }
        }

        return -1; // 理论上不会执行到这里（因为一定能达到>=m）
    }


    // 2.漂亮数字（筛法）
    public static  List<Integer> getSushu(int n){
        if (n<2) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean [] isPrime = new boolean[n+1];
        for (int i = 2; i < n+1 ; i++) {
            if (!isPrime[i]){
                for (int j = i *i; j <n+1; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for (int i = 2; i < n+1 ; i++) {
            if (!isPrime[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    //2 测试方法
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        int count = 0;

        //n开根
        List<Integer> ans = meituan.getSushu(n);
        for (Integer num: ans
             ) {
            System.out.printf(" "+ num);
        }

        for (Integer num :ans) {
            for (int i = num; i <= num*num ; i+=num) {
                 if (i <=n){
                     System.out.println("ans:"+i);
                     count++;
                 }
            }
        }

        //最后判断n本身逻辑
        if (ans.contains(n)){
            count++;
        }
        System.out.println(count);
    }*/

    //3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int round = Integer.parseInt(st.nextToken());
        while (round-- > 0){
            int len = Integer.parseInt(br.readLine());

            String  str = br.readLine();

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int coutdiff=0;
            boolean flag = false;

            for (int i = 0; i < len; i++) {
                if (chars[i] != str.charAt(i)){
                    coutdiff++;
                }
                if (i>0 && chars[i] == chars[i-1]){
                    flag = true;
                }
            }

            if (coutdiff == 2){
                System.out.println("YES");
            }else if (coutdiff == 0){
                if (flag){
                    System.out.println("YES");
                }else System.out.println("NO");

            }else {
                System.out.println("NO");
            }


        }

    }
}
