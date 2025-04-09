package leetcode.binarytree;

import struct.TreeNode;

public class 中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode ans = myBuildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);

        return ans;
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int leftBegin, int leftEnd, int rightBegin, int rightEnd){
        int len = leftEnd - leftBegin + 1;
        int lenZuo =0,lenYou =0;
        int rootInorderIndex = 0;
        TreeNode left = null;
        TreeNode right = null;

        //跳出
        if (len == 1 ){
            return new TreeNode(inorder[leftBegin]);
        }

        //取左右子树对应的数组下标，进递归
        int rootval = postorder[rightEnd];

        //处理左右子树
        for (int i = leftBegin; i <= leftEnd; i++) {
            if (inorder[i] == rootval){
                rootInorderIndex = i;
            }
        }
        lenZuo = rootInorderIndex - leftBegin;
        lenYou = len - lenZuo - 1;

        if (lenZuo == 0){//左子树空
            left = null;
        }else {
            left = myBuildTree(inorder, postorder,leftBegin,rootInorderIndex-1,rightBegin,rightBegin+lenZuo-1);
        }

        if (lenYou == 0){//右子树空
            right = null;
        }else {
            right = myBuildTree(inorder, postorder, rootInorderIndex+1,leftEnd,rightEnd-lenYou,rightEnd-1);
        }

        //构造树
        TreeNode root = new TreeNode(postorder[rightEnd]);
        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode ans = new 中序与后序遍历序列构造二叉树().buildTree(inorder,postorder);
    }
}
