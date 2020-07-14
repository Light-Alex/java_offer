import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目：二叉搜索树与双向链表
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/**
 * 二叉搜索树：
 * 如果有左孩子或者右孩子，则满足以下关系：
 * 左孩子的值 < 根结点的值 < 右孩子的值
 * 且左子树上所有结点的值均小于根结点的值，右子树上所有结点的值均大于根结点的值
 * 
 *          6
 *        /   \
 *       4     8
 *     /  \   /
 *    3    5 7
 *        
 * 中序遍历：(3, 4, 5, 6, 7, 8)，即二叉搜索树的中序遍历是排好序的
 * 将中序遍历中的元素两两互指就得到了一个排好序的双向链表了
 * 可以使用非递归的中序遍历算法
 */
public class test31 {
    public static void main(String[] args) {
        test31 t = new test31();
        TreeNode t1 = t.new TreeNode(6);
        TreeNode t2 = t.new TreeNode(4);
        TreeNode t3 = t.new TreeNode(8);
        TreeNode t4 = t.new TreeNode(3);
        TreeNode t5 = t.new TreeNode(5);
        TreeNode t6 = t.new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;

        t.Convert(t1);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // 非递归的中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = pRootOfTree;

        LinkedList<TreeNode> result = new LinkedList<TreeNode>();

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                result.add(node);
                tempNode = node.right;
            }
        }

        TreeNode head = result.peek();
        int len = result.size();

        for(int i = 0; i < len - 1; i++){
            TreeNode temp = result.poll();
            temp.right = result.peek();
            result.peek().left = temp;
        }

        return head;
    }
}