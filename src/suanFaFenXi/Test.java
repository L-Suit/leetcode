package suanFaFenXi;

public class Test {
    public static void main(String[] args) {
        Pair p1 = new Pair(1,3);
        Pair p2 = new Pair(2,4);
        Pair p3 = new Pair(3,5);
        Pair [] pairs = new Pair[]{p1,p2,p3};

        int [][]ans = DisjointSet.disjointSearch(7,pairs);
        for (int[] a :ans) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
