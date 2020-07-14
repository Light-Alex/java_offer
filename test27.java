/**
 * 题目：二叉树的镜像
 * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：
 * 源二叉树：       
    	     8
    	  /     \
    	 6      10
    	/ \    /   \
       5   7  9     11
    镜像二叉树：
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7   5
 */

// 使用递归的方法 先处理根结点，在处理左结点和右结点
public class test27 {
    public static void main(String[] args) {
        
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode tempNode = new TreeNode(0);

        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }
}