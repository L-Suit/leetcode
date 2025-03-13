package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import struct.TreeNode;

public class 递归遍历 {

    public List<Integer> orderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);


        return res;
    }

    //前序
    private void preOrder(TreeNode root, List<Integer> res) {
        //跳出条件
        if (root == null) return;

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right,res);
    }

    //后序遍历
    public void postorder(TreeNode root, List<Integer> res) {
        //跳出条件
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        //跳出条件
        if (root == null) return;
        postorder(root.left, res);
        res.add(root.val);
        postorder(root.right, res);
    }

}
