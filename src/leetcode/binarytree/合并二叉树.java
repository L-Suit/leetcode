package leetcode.binarytree;

import struct.TreeNode;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();

        //跳出
        if (root1 == null && root2 == null){
            return null;
        }
        if (root1 == null){
            root = root2;
            return root;
        }
        if (root2 == null){
            root = root1;
            return root;
        }
        if (root1 != null && root2 != null){
            root.val = root1.val + root2.val;
        }

        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);

        return root;
    }
}
