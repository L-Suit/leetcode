package leetcode.binarytree;

import struct.TreeNode;

public class 二叉搜索树的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (root.val == val){//找到，返回
                return root;
            }
            if (root.val > val){
                root = root.left;
            }else if (root.val < val){
                root = root.right;
            }
        }

       return null;
    }
}
