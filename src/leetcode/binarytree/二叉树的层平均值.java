package leetcode.binarytree;

import struct.TreeNode;

import java.util.*;

public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans  = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();

        Double sum=0.0;
        int count;

        queue.offerFirst(root);
        while (!queue.isEmpty()){
            count = queue.size();
            sum = 0.0;
            for (int i = 0; i < count; i++) {//遍历当前层，处理每个结点
                TreeNode node = queue.pollLast();//出队一个
                sum += node.val;
                if (node.left!=null){//左子树不为空，压左子树
                    queue.offerFirst(node.left);
                }
                if (node.right!=null){//子树不为空，压子树
                    queue.offerFirst(node.right);
                }
            }
            ans.add(sum/count);
        }

        return ans;
    }

}
