package leetcode.binarytree;

import struct.TreeNode;

public class 最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int res;
        if (root.left == null && root.right == null) return 1;//叶子结点

        if (root.left == null){
            res = minDepth(root.right) + 1;
        }
        else if (root.right == null){
            res = minDepth(root.left) + 1;
        }
        else{
            res = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        return res;
    }
}
