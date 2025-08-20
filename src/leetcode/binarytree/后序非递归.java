package leetcode.binarytree;

import struct.TreeNode;

import java.util.*;

public class 后序非递归 {
    public List<Integer> postorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.left !=null){
                stack.push(node.left);
            }
            if (node.right !=null){
                stack.push(node.right);
            }
        }

        for (int i = 0; i < res.size()/2; i++) {
            int temp = res.get(i);
            res.set(i,res.get(res.size()-1-i));
            res.set(res.size()-1-i,temp);
        }


        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }

        List<Integer> realAns = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            realAns.add(ans.get(ans.size()-i-1));
        }
        return realAns;
    }
}
