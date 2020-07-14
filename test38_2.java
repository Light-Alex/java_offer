import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：二叉搜索树的第k个结点
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */

/**
 * 二叉搜索树：
 *          5
 *       /     \
 *      3       7
 *    /   \   /   \
 *   2     4 6     8
 * 
 * 中序遍历：{2, 3, 4, 5, 6, 7, 8}
 * 
 * 方法：使用中序遍历，二叉搜索树的中序序列是从小到大排好序的序列，所以第k小的结点是中序序列中第k个元素
 * 
 * 中序遍历非递归版(使用栈)
 */
public class test38_2 {

    ArrayList<TreeNode> result = new ArrayList<TreeNode>();

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

    public void midOrderStack(TreeNode pRoot){
        if(pRoot == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = pRoot;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                result.add(node);
                tempNode = node.right;
            }
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k){
        midOrderStack(pRoot);

        return (k < 1 || k > result.size()) ? null : result.get(k-1);
    }
}