package suanFaFenXi;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Duoxiangshi {
    public static void main(String[] args) {
        //A表示被除数， B表示除数
        double []A={4.0,4.0,-5.0,6.0,-3.0};
        double []B={-1.0,1.0,-1.0};

        double []Shang=new double[A.length-B.length+1]; //最高次是n次,是n+1 项的
        double []Yushu=new double[A.length-B.length];
        divide(A,4,B,2,Shang,2,Yushu,1);
        DecimalFormat df=new DecimalFormat("0.0");
        for(int i=0;i<Shang.length;i++){
            System.out.println("商多项式的系数R("+i+")="+df.format(Shang[i]));
        }
        for(int i=0;i<Yushu.length;i++){
            System.out.println("余多项式的系数R("+i+")="+df.format(Yushu[i]));
        }
    }
    //涉及到除法，结果可能是小数，所以用double数组
    static void divide(double A[],int m,double B[],int n,double Shang[],int k,double Yushu[],int l){
        //a表示被除数，m是被除数的最高次 b表示除数，n是除数的最高次
        //其中k=m-n,余数最高次l=n-1,比除数的次数少1
        //商的每一项系数都是被除数除以除数，但是要注意在这个过程中，被除数系数的更新
        Arrays.fill(Shang,0.0);
        int ll=m; //ll是用来遍历被除数的项数的
        int mm=0;
        for(int i=k;i>=0;i--){
            Shang[i]=A[ll]/B[n];  //商的每一项系数，都是除以除数的最高项得来的
            //然后更新被除数
            mm=ll-1; //从下一项开始影响，而非当前项
            for(int j=1;j<=n;j++){
                A[mm]-=Shang[i]*B[n-j];
                mm--;
            }
            ll--;
        }
        //最后更新后的被除数就是余数
        for (int i=0;i<=l;i++)
        {
            Yushu[i]=A[i];
        }
    }
}

