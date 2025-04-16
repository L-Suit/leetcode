package leetcode.tanxin;

import java.util.Arrays;

public class 分饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int cout=0,bingganIndex=s.length-1;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = g.length-1; i >=0 ; i--) {
            if (bingganIndex<0) {
                break;
            }
            if (g[i] > s[bingganIndex]){//最大的饼干满足不了小孩
                continue;
            }

            //分饼干
            bingganIndex --;
            cout++;
        }

        return cout;
    }
}
