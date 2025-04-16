import java.io.*;
import java.util.*;

public class Test {
    static class Task {
        int ability;
        int profit;

        Task(int ability, int profit) {
            this.ability = ability;
            this.profit = profit;
        }
    }

    public static long maxProfit(List<Task> tasks, int[] workers) {
        // 按任务能力升序排序，若能力相同取收益大的
        tasks.sort((a, b) -> a.ability == b.ability ? b.profit - a.profit : a.ability - b.ability);

        // 构建有效任务列表：能力、对应最大收益
        TreeMap<Integer, Integer> abilityToProfit = new TreeMap<>();
        int maxProfit = 0;
        for (Task task : tasks) {
            maxProfit = Math.max(maxProfit, task.profit);
            abilityToProfit.put(task.ability, maxProfit); // 保证每个能力对应当前最大收益
        }

        long totalProfit = 0;
        for (int ability : workers) {
            Map.Entry<Integer, Integer> entry = abilityToProfit.floorEntry(ability); // 找到不超过工人能力的最大任务
            if (entry != null) {
                totalProfit += entry.getValue();
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 任务数量
        int m = Integer.parseInt(st.nextToken()); // 工人数量

        // 读入任务数据
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ability = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());
            tasks.add(new Task(ability, profit));
        }

        // 读入工人数据
        int[] workers = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            workers[i] = Integer.parseInt(st.nextToken());
        }

        long result = maxProfit(tasks, workers);
        System.out.println(result);
    }
}
