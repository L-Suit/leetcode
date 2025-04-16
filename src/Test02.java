import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {

    static  final int N= (int)(4e5 +10);
    static int n,q,mx;

    static int[] a  = new int[N];
    static int[] tr = new int[N];
    static int[] ans = new int[N];

    static class Node implements Comparable<Node>{
        int l,r,id;
        boolean f;

        @Override
        public int compareTo(Node t) {
            return  Integer.compare(this.r,t.r);
        }

    }
    static Node[] op = new Node[N];
    static int lt(int x){
        return x & -x;
    }

    static void add(int x,int v){

        for (int i = x; i <=n ; i+= lt(i)) {
            tr[i] += v;
        }
    }

    static int   query(int x){
        int ans = 0;
        for (int i = x; i >0 ; i=lt(i)) {
            ans += tr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        q = in.nextInt();

        Map<Integer,Boolean> st = new HashMap<>();

        for (int i = 1; i <=n ; i++) {
            a[i] = in.nextInt();
            if (!st.containsKey(a[i])){
                st.put(a[i], true);
                mx++;
            }

        }

        for (int i = n+1; i <= 2*n; i++) {
            a[i] = a[i-n];
        }
        int L=1,R=2*n;

        for (int i = 1; i <=q ; i++) {
            char c = in.next().charAt(0);
            int x = in.nextInt();
            op[i] = new Node();
            op[i].id =i;

            if (x>=n) op[i].f = true;
            else op[i].f = false;

            x%=n;

            if (c =='L'){
                int l=L,r=L+x-1;
                L = r+1;
                if (L>n) L -=n;
                op[i].l = l;
                op[i].r = r;

            }else {
                int l = R-x+1,r=R;
                R = l-1;
                if (R<=n) R+=n;
                op[i].l =l;
                op[i].r =r;

            }

        }
        Arrays.sort(op,1,q+1);

        Map<Integer,Integer> pre = new HashMap<>();
        int pos =0;
        for (int i = 1; i <=q ; i++) {
            int l =op[i].l,r=op[i].r,id = op[i].id;
            if (op[i].f){
                ans[id] =mx;
            }else {
                while (pos <r){
                    ++pos;
                    if (pre.containsKey(a[pos])){
                        add(pre.get(a[pos]),-1);
                    }
                    add(pos,1);
                    pre.put(a[pos],pos);

                }
                ans[id] = query(r) - query(l-1);

            }
        }

        for (int i = 1; i <=q ; i++) {
            System.out.println(ans[i]);
        }


    }
}
