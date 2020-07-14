import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

/**
 * 方法：
 * 通过递归实现
 * 找出根结点在中序序列中的位置，可根据此位置将 先序序列和中序序列 分成左右两部分，然后继续进行递归操作
 */
public class test25 {
    public static void main(String[] args) {
        
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || pre.length != in.length){
            return null;
        }

        int root = pre[0];
        TreeNode rootNode = new TreeNode(root);
        if(pre.length == 1){
            return rootNode;
        }

        int rootIndex = 0;
        for(; rootIndex < in.length; rootIndex++){
            if(in[rootIndex] == root){
                break;
            }
        }

        rootNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex+1), Arrays.copyOfRange(in, 0, rootIndex));
        rootNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex+1, pre.length), Arrays.copyOfRange(in, rootIndex+1, in.length));
        
        return rootNode;
    }

    public class TreeNode {
        TreeNode(int x) {
            val = x; 
        }
        int val;
        TreeNode left;
        TreeNode right;
    }
}