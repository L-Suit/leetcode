package leetcode.binarytree;

import struct.TreeNode;

import java.util.*;

public class 前序非递归 {
    public List<Integer> preorderTraversal0(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }

        }


        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }

        return ans;

    }
}
