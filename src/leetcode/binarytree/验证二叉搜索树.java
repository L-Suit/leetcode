package leetcode.binarytree;

import struct.TreeNode;

public class 验证二叉搜索树 {

    long max = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        //传null
        if (root == null) return true;

        boolean flagl = isValidBST(root.left);

        if (root.val > max){
            max = root.val;
        }else return false;

        boolean flagr = isValidBST(root.right);
        return flagl && flagr;
    }
}
