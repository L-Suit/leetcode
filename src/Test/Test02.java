package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test02 {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(-4);
        list.add(6);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        System.out.println(list);

        //list转包装数组
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println(array);
        //包装数组转基本类型
        int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        int[] array2 = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        Integer[] array3 = Arrays.stream(array2).boxed().toArray(Integer[]::new);

        int[] array1 = list.stream().mapToInt(Integer::intValue).toArray();


        //队列
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.pollFirst();
        for (Integer i: deque){
            System.out.print(i);
        }


        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(2,2);
        treeMap.put(4,5);
        Integer i = treeMap.lowerKey(4);
        System.out.println();
        System.out.println(i);


        //长字符串
        System.out.println("长字符串");
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

        BufferedReader br1 =new BufferedReader(new InputStreamReader(System.in));



    }
}
