import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上往下打印二叉树
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

// 使用广度优先算法
public class test28 {
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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> nodeList = new LinkedList<TreeNode>();

        nodeList.add(root);

        while(!nodeList.isEmpty()){
            TreeNode currentNode = nodeList.poll();
            result.add(currentNode.val);

            if(currentNode.left != null){
                nodeList.add(currentNode.left);
            }

            if(currentNode.right != null){
                nodeList.add(currentNode.right);
            }
        }

        return result;
    }
}