
import java.util.*;

public class Main {

//字符串去重+对比
/*    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n  = sc.nextInt();

        for (int i = 0; i < n; i++){
            String s1 = sc.next();
            String s2  = sc.next();
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();


            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int j = 0; j < s1.length(); j++) {
                Character c1 = s1.charAt(j);
                if (!set1.contains(c1)) {
                    sb1.append(c1);
                    set1.add(c1);
                }
            }

            for (int j = 0; j < s2.length(); j++) {
                Character c2 = s2.charAt(j);
                if (!set2.contains(c2)) {
                    sb2.append(c2);
                    set2.add(c2);
                }
            }

            s1 = sb1.toString();
            s2 = sb2.toString();
            System.out.println(s1.equals(s2) ? "YES" : "NO");
        }
    }*/
    //2 分配任务最大收益，贪心
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        for (int i = 0; i < round; i++) {//n组测试数组
            int n = in.nextInt();
            int m = in.nextInt();
            int sumMoney = 0;
            Map<Integer,Integer> valToMoney = new HashMap<>();
            int[] taskVal = new int[n];
            int[] taskMoney = new int[n];
            int[] worker = new int[m];
            //初始化各数组
            for (int j = 0; j < n; j++) {
                taskVal[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                taskMoney[j] = in.nextInt();
            }
            for (int j = 0; j < m; j++) {
                worker[j] = in.nextInt();
            }

            for (int j = 0; j < n; j++){
                valToMoney.put(taskVal[j],taskMoney[j]);
            }

            Arrays.sort(taskVal);

            //分配任务
            for (int j = 0; j < m; j++) {
                int maxMoney = 0;
                int workerVal = worker[j];
                boolean flag = false;
                for (int k = n-1; k >=0 ; k--) {//找到能力范围内所有任务，取最大收益
                    if (flag==false && workerVal >= taskVal[k]){
                        flag = true;
                        for (int l = k; l >=0 ; l--) {//打擂，找到最大收益
                            maxMoney= Math.max(maxMoney,valToMoney.get(taskVal[l]));
                        }
                    }else {
                        continue;
                    }
                }
                sumMoney += maxMoney;
                System.out.println(maxMoney);
            }
            System.out.println(sumMoney);
        }
    }

    //3
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int round = in.nextInt();
        for (int i = 0; i < round; i++) {
            long n = in.nextLong();
            long m = in.nextLong();

            double mid = n*1.0/m;

            boolean fmid = (mid%1 == 0);//mid的整数xing

            //如果mid不是整数和几.5直接NO
            if (!fmid && mid %1 != 0.5){
                System.out.println("NO");
            }

            boolean fm = (m%2 == 0);//m的偶性

            if (fm & fmid){
                System.out.println("NO");
            }else if (!fm &  !fmid){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }


        }
    }*/

    //4
/*    static  class  Point{
        double x,y;
        Point(double x,double y){
            this.x = x;
            this.y = y;
        }
    }

    static class Circle{
        Point center;
        double radius;

        public Circle(Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }
    }


    static  Circle findMinCoverCir(Point[] points) {
        Collections.shuffle(Arrays.asList(points));

        //初始化
        Circle circle = new Circle(points[0], 0);
        for (int i = 1; i < points.length; i++) {
            if (!circleContians(circle, points[i])){
                circle = updateCircle(circle, points[i]);
            }

        }
        return circle;
    }

    static Circle updateCircle(Circle circle, Point newPoint) {
        if (!circleContians(circle, newPoint)){
            if (circle.radius==0){
                return new Circle(newPoint, 0);
            }
            double dx = newPoint.x - circle.center.x;
            double dy = newPoint.y - circle.center.y;
            double newRadius = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            Point newCenter = new Point(circle.center.x + dx / 2, circle.center.y + dy / 2);
            return  new Circle(newCenter, newRadius);
        }
        return circle;
    }

    static boolean circleContians(Circle circle, Point point){
        double distance = Math.sqrt(Math.pow(point.x - circle.center.x, 2) + Math.pow(point.y - circle.center.y, 2));
        return distance <= circle.radius;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point[] points = new Point[6];
        for (int i = 0; i < 6; i++) {
            points[i] = new Point(in.nextDouble(), in.nextDouble());
        }

        Circle circle = findMinCoverCir(points);
        System.out.println(circle.radius);
    }*/
}