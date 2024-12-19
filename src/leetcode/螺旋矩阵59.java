package leetcode;

public class 螺旋矩阵59 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1,epoch = 0;

        while (count<=n*n){
            //向右
            for (int j = epoch; j <=n-1-epoch; j++){
                nums[epoch][j] = count++;
            }

            //向下
            for (int i = epoch+1; i <=n-epoch-1;i++){
                nums[i][n-1-epoch] = count++;
            }

            //向左
            for (int j = n-2-epoch; j >=epoch; j--){
                nums[n-1-epoch][j] = count++;
            }

            //向上
            for (int i = n-2-epoch; i >=epoch+1; i--){
                nums[i][epoch] = count++;
            }

            epoch++;
        }

        return nums;

    }
}
