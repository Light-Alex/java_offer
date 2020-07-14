import java.util.Stack;

/**
 * 题目：二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/**
 * 方法二：深度优先, 非递归版(使用栈)
 */

public class test49_2 {
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

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;
        int depthOfTree = 0;
        int depth = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
                depth++;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    depthOfTree = depth > depthOfTree ? depth : depthOfTree;
                    depth = nodeList.size();
                }
            }
        }

        return depthOfTree;
    }
}