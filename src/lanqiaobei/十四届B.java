package lanqiaobei;

public class 十四届B {
    public static void main(String[] args) {
        for (int kk = 0; kk < 3; kk++) {
            dfs(1, 0, kk);
        }
        System.out.println(sum);
    }



    static int sum = 0;
    static int[][] arr = { { 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 } };

    private static void dfs(int i, int j, int k) {
        if (k==0){
            arr[i][j]= arr[i-1][j]&arr[i-1][j+1];
        } else if (k==1) {
            arr[i][j] = arr[i - 1][j] | arr[i - 1][j + 1];
        } else if (k == 2) {
            arr[i][j] = arr[i - 1][j] ^ arr[i - 1][j + 1];
        }


        if (i==4&&j==0){
            if (arr[i][j] == 1) {
                sum++;
                System.out.println(sum);
            }
            return;
        }

        //i,j变为下一个计算点
        if (j == 4 - i) {
            i++;
            j = 0;
        } else {
            j++;
        }


        for (int kk = 0; kk < 3; kk++) {
            dfs(i,j,kk);
        }

    }

}
