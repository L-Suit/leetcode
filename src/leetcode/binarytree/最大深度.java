package leetcode.binarytree;

import struct.TreeNode;

public class 最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
