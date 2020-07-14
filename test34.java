/**
 * 题目：二叉树的下一个结点
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/**
 *             1
 *          /     \
 *         2       3
 *       /   \   /   \
 *      4     5 6     7
 *               \
 *                8
 * 中序遍历：{4, 2, 5, 1, 6, 8, 3, 7}
 * 
 * 方法：判断当前结点有没有右子树
 * 1、有右子树，那下一个结点是右子树最左边那个结点
 * 2、没有右子树，那分两种情况：
 *   (1) 是父结点的左孩子，那么父结点是下一个结点
 *   (2) 是父结点的右孩子, 那么找它的父结点...直到找到其父结点的左孩子是当前结点，那么父结点是下一个结点，没找到说明当前结点是尾结点
 */  

public class test34 {
    public static void main(String[] args) {
        
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
    
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }

        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            TreeLinkNode node = pNode;
            while(node.next != null){
                if(node.next.left == node){
                    return node.next;
                }else{
                    node = node.next;
                }
            }
        }

        return null;
    }
}