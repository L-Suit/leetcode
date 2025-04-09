package leetcode.binarytree;

import struct.TreeNode;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        boolean res = isDuichen(root.left,root.right);
        return  res;
    }

    private boolean isDuichen(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        boolean flag1 = (left.val == right.val);
        boolean flag2 = isDuichen(left.left,right.right);
        boolean flag3 = isDuichen(left.right,right.left);

        if (flag1 && flag2 && flag3) {
            return true;
        }else return false;
    }
}
