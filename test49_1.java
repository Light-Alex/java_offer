/**
 * 题目：二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/**
 * 方法一：深度优先, 递归版
 */

public class test49_1 {
    public static void main(String[] args) {
        
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}