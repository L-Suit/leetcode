import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 任务数量
        int m = Integer.parseInt(st.nextToken()); // 工人数量

        // 读入任务数据
        List<Integer> tasks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int ability = Integer.parseInt(st.nextToken());
            tasks.add(ability);
        }

        for (Integer num:tasks
             ) {
            System.out.println(num);
        }


        // 读入工人数据
        int[] workers = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            workers[i] = Integer.parseInt(st.nextToken());
            System.out.println(workers[i]);
        }

    }
}
