/**
 * 题目：对称的二叉树
 * 题目描述：请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/** 
 *             1
 *           /   \
 *          2     2
 *         / \   / \
 *        3   4 4   3
 * 方法：使用递归实现, 递归判断某结点的左结点和右结点的值是否相等
 */

public class test35 {
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

    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }

        return isMirror(pRoot.left, pRoot.right);
    }

    boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else{
            if(left.val == right.val){
                return isMirror(left.left, right.right) && isMirror(left.right, right.left);
            }else{
                return false;
            }
        }
    }
}