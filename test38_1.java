import java.util.ArrayList;

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
 * 中序遍历递归版
 */
public class test38_1 {

    ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();

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

    public void midOrderRecursive(TreeNode pRoot){
        if(pRoot == null){
            return;
        }

        midOrderRecursive(pRoot.left);
        nodeList.add(pRoot);
        midOrderRecursive(pRoot.right);
    }

    TreeNode KthNode(TreeNode pRoot, int k){
        midOrderRecursive(pRoot);

        return (k < 1 || k > nodeList.size()) ? null : nodeList.get(k-1);
    }
}