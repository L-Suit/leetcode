package bishi;

import java.util.*;

public class pdd {
    //1 A
     /*public static void main(String[] args) {
        //声明一个链表，节点的值是1~5
        int [] nums = {1,2,8,23,74,3,4,5,32,8};
        Main main = new Main();
        for (int i = 0; i < 130; i++) {
            System.out.println(i+" "+main.test(i));
        }

    }

    //交换链表中第k个结点和倒数第k个节点的值
    public ListNode exchange (ListNode head, int k) {
        // write code here
        ListNode tmp = head;
        ListNode zhengshu = head;
        ListNode daoshu = head;

        int n = 0;
        while (head != null){
            n++;
            if (n == k){
                zhengshu = head;
            }
            head = head.next;
        }

        //倒数第k个
        ListNode l = tmp;
        ListNode r = tmp;

        while (k-->=1){
            r = r.next;
        }

        while (r != null){
            l = l.next;
            r = r.next;
        }

        daoshu = l;

        int t = zhengshu.val;
        zhengshu.val = daoshu.val;
        daoshu.val = t;

        return tmp;
    }

    public int test (int a) {
        if (a<=9) return a+10;
        // write code here
        List<Integer> anslist = new ArrayList<>();
        int ans =0;

        boolean f = true;//能否被整除
        while (f){
            f = false;
            //从9-2 轮流尝试除以
            for (int i = 9; i >=2 ; i--) {
                if (a % i == 0){
                    anslist.add(i);
                    a /= i;
                    f = true;
                    break;
                }
            }
        }

        if (anslist.size() == 0){
            return 0;
        }
        //拼接答案
        int [] ansNum = anslist.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ansNum);

        for (int i = 0; i <ansNum.length; i++) {
           if (i != 0){
               ans *= 10;
           }
            ans += ansNum[i];
        }

        return ans;
    }

    public ArrayList<Integer> twoSum (int[] nums, int target) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map2Index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map2Index.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map2Index.containsKey(target - nums[i]) && map2Index.get(target - nums[i])!=i ){
                ans.add(i);
                ans.add(map2Index.get(target - nums[i]));
                break;
            }
        }
        return ans;
    }*/

    /*public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int targetLen = sc.nextInt();

        List<Character> ansCh = new ArrayList<>();

        String [] strs = new String[n];
        for (int i = 0; i <n ; i++) {
            String str = sc.next();
            int len = sc.nextInt();
            char [] chs = str.toCharArray();
            Arrays.sort(chs);
            //取前len个加入ans中
            for (int j = 0; j <len ; j++) {
                ansCh.add(chs[j]);
            }
        }

        ansCh.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });

        StringBuffer  bf  = new StringBuffer();

        for (int i = 0; i < targetLen; i++) {
            bf.append(ansCh.get(i));
        }

        System.out.println(bf);
    }*/

    //2 最后写出，没交上
    static Map<Integer, List<Integer>> mapvs = new HashMap<>();
    static  Map<Integer,Integer> mapLen = new HashMap<>();
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int numbers = sc.nextInt();
        int issueCount = sc.nextInt();

        //Map<Integer,List<Integer>> mapvs = new HashMap<>();


        //存入所有比较
        for (int i = 0; i <issueCount ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!mapvs.containsKey(a)){
                mapvs.put(a,new ArrayList<>());
            }
            mapvs.get(a).add(b);
        }

        int beishu10 = 0;

        for (Integer num:mapvs.keySet()) {
            mapLen.put(num,getLen(num));
        }
        for (Integer num: mapLen.keySet()
        ) {
            System.out.println(num + " len:" + mapLen.get(num));
            beishu10 += mapLen.get(num);
        }

        System.out.println(beishu10*10 + numbers*100);
    }

    static int getLen(int tar){
        if (mapLen.containsKey(tar)){
            return mapLen.get(tar);
        }
        if (!mapvs.containsKey(tar)){
            return 0;
        }else {
            int size = mapvs.get(tar).size();
            int maxSize =  Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                int tmp = mapvs.get(tar).get(i);
                int tmpLen = getLen(tmp);
                if (tmpLen > maxSize) {
                    maxSize = tmpLen;
                }
            }
            return maxSize + 1;
        }
    }


    //3
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int round = sc.nextInt();
        for (int i = 0; i < round; i++) {
            int n = sc.nextInt();
            if (n ==1) {
                System.out.println(0);
                continue;
            }


            int[] nums = new int[n];
            //遍历赋值
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }

            int size = 0;
            int[] tails = new int[n];
            for (int x:nums) {
                int in=0,j=size;
                while (in!=j){
                    int m = (in + j) / 2;
                    if(tails[m] <x){
                        in = m+1;
                    }else {
                        j = m;
                    }
                }
                tails[in] =x;
                if (in == size){
                    size++;
                }
            }

            System.out.println(n - size);
        }
    }*/

    //4
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }*/
}
