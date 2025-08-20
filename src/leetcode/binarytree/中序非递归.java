package leetcode.binarytree;

import struct.TreeNode;

import java.util.*;

public class 中序非递归 {
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

        }


        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root ==null){
            return ans;
        }
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null) {
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2,t3,null);
        TreeNode t1 = new TreeNode(1, null,t2);
        List<Integer> list = inorderTraversal(t1);
        System.out.println(list);
    }
}
