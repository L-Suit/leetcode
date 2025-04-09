package leetcode.binarytree;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //是否存在目标路径
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null ){ //跳出
            if (root.val == targetSum){
                return true;
            }  else return false;
        }


        return hasPathSum(root.left, targetSum - root.val)|| hasPathSum(root.right, targetSum - root.val);
    }

    //找到所有满足从「根节点」到某个「叶子节点」经过的路径上的节点之和等于目标和的路径
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        dfs(root, targetSum);

        return ans;
    }

    private void dfs(TreeNode root, int targetSum) {
        path.add(root.val);

        //跳出
        if (root.left == null && root.right == null){   //叶子节点
            if (root.val == targetSum){//找到路径
                ans.add(new ArrayList<>(path));
                return;
            }
        }

        //继续遍历左右子节点
        if (root.left != null){
            dfs(root.left,targetSum- root.val);
            path.remove(path.size()-1);//回溯
        }
        if (root.right != null){
            dfs(root.right,targetSum- root.val);
            path.remove(path.size()-1);//回溯
        }

    }


}
