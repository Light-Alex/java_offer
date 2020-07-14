import java.util.LinkedList;

/**
 * 题目：二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

/**
 * 方法三：广度优先，使用队列
 */

public class test49_3 {
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

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        int depthOfTree = 0;

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();

                if(node.left != null){
                    nodeList.add(node.left);
                }

                if(node.right != null){
                    nodeList.add(node.right);
                }
            }
            depthOfTree++;
        }

        return depthOfTree;
    }
}