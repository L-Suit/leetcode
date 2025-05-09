package leetcode.tulun;

import java.util.*;

public class 拓扑排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> lineMap = new ArrayList<>();
        int [] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            lineMap.add(new ArrayList<>());
        }

        //读取所有line
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            lineMap.get(s).add(t);
            indegree[t]++;
        }

        //初始化入度位0的起点
        Queue<Integer> queue =new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        //循环处理拓扑排序
        while (!queue.isEmpty()){
            int cur = queue.poll();
            ans.add(cur);
            //处理他的所有边，涉及的点入度减一
            List<Integer> list = lineMap.get(cur);
            for (int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if (indegree[list.get(i)] == 0){
                    queue.offer(list.get(i));
                }
            }

        }


        //输出答案
        if (ans.size() == n){
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if (i != ans.size() - 1){
                    System.out.print(" ");
                }
            }
        }else {
            System.out.println("-1");
        }

    }
}
