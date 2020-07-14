/**
 * 题目：平衡二叉树
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */

/**
 *         1
 *      /     \
 *     2       3
 *      \    /   \
 *       4  5     6
 *           \
 *            7
 * 平衡二叉树(Balanced Binary Tree)：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 * 
 * 方法一：自上而下，使用递归，实现一个求深度的函数, 判断左右子树的高度差的绝对值是否不超过1，并判断左右两个子树是不是都是平衡二叉树
 */
public class test50_1 {
    public static void main(String[] args) {
        
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }

        return Math.abs(depthOfTree(root.left) - depthOfTree(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int depthOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
    }
}