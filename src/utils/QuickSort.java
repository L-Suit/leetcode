package utils;

public class QuickSort {
    public static void qsort(int [] nums,int l,int r){
        if (l>=r) return;
        int key,i=l,j=r;
        key = nums[l];//选取中轴点

        while(i<j){
            while (i<j && nums[j]>=key) j--;
            while (i<j && nums[i] <=key) i++;
            if (i<j)  swap(nums,i,j);
        }
        swap(nums,l,i);
        qsort(nums,l,i-1);
        qsort(nums,i+1,r);
    }

    public static void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
