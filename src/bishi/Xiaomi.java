package bishi;

import java.util.Scanner;

/**
 * @author lishihao
 */
public class Xiaomi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int deep = 10000001;

        int kuan = sc.nextInt();
        boolean[][] data = new boolean[kuan][deep];
        for (int i = 0; i < kuan; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                data[i][j] = true;
            }
        }

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int ans = 0;
            int height = sc.nextInt();
            int weight = sc.nextInt();
            int meetIndex =0;
            //从右边移动
            for (int j = deep-weight-2 ; j >=0; j--) {
                int flag = 0 ;
                //校验这一列是否有方块
                for (int k = 0; k < height; k++) {
                    if (data[k][j]){
                        flag =1;
                        break;
                    }
                }
                //发生碰撞
                if (flag ==1){
                    ans = j+1;
                    //放置
                    for (int k = 0; k < height; k++){
                        data[k][j+weight] = true;
                    }
                    break;
                }



            }

            System.out.println(ans);
        }

    }


}
