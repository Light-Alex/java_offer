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
 * 方法二：自下而上，递归遍历左右子树，发现高度差的绝对值 > 1，则返回-1(由求深度的函数完成)，结果是-1则该二叉树不是平衡二叉树，否则就是
 */
public class test50_2 {
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

        return depthOfTree(root) != -1 ? true : false;
    }

    public int depthOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depthOfTree(root.left);

        if(left == -1){
            return -1;
        }

        int right = depthOfTree(root.right);

        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}