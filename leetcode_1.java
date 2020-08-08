import java.util.Stack;

/**
 * 题目：恢复二叉搜索树
 * 
 * 题目描述： 二叉搜索树中的两个节点被错误地交换。 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例1： 输入: [1,3,null,null,2]
 * 
 *   1   /  3   \   2
 * 
 * 输出: [3,1,null,null,2]
 * 
 *   3   /  1   \   2
 * 
 * 示例2： 输入: [3,1,4,null,null,2]
 * 
 * 3 / \ 1 4   /   2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * 2 / \ 1 4   /  3
 * 
 */
public class leetcode_1 {
    public static void main(String[] args) {
        
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 非递归的中序遍历，使用栈
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;
        double temp = Double.NEGATIVE_INFINITY;

        TreeNode firstNode = null;
        TreeNode secondNode = null;
        int k = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                if(node.val >= temp){
                    temp = node.val;
                    if(k == 0){
                        firstNode = node;
                    }
                }else{
                    secondNode = node;
                    temp = node.val;
                    if(k > 0){
                        break;
                    }
                    k++;
                }
                tempNode = node.right;
            }
        }

        if(firstNode != null && secondNode != null){
            int tempValue = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = tempValue;
        }
    }
}