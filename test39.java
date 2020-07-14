import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：序列化二叉树
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
序列化时通过某种符号表示空节点（#），以！表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */

/**
 *           10
           /    \
          5      6
         / \
        2   3
       /
      1
    
    先序遍历：
    序列化结果：[10, 5, 2, 1, #, #, #, 3, #, #, 6, #, #] -> "10 5 2 1 # # # 3 # # 6 # #"

    方法：使用递归
 */
public class test39 {

    ArrayList<String> result = new ArrayList<String>();
    LinkedList<String> nodeList = new LinkedList<String>();

    public static void main(String[] args) {
        test39 t = new test39();
        TreeNode t1 = t.new TreeNode(10);
        TreeNode t2 = t.new TreeNode(5);
        TreeNode t3 = t.new TreeNode(6);
        TreeNode t4 = t.new TreeNode(2);
        TreeNode t5 = t.new TreeNode(3);
        TreeNode t6 = t.new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        System.out.println(t.Serialize(t1));
        t.Deserialize("10 5 2 1 # # # 3 # # 6 # #");
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void preOrderRecursive(TreeNode root){
        if(root == null){
            result.add("#");
            return;
        }

        result.add(String.valueOf(root.val));
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    String Serialize(TreeNode root) {
        if(root == null){
            return null;
        }

        preOrderRecursive(root);
        return String.join(" ", result);
    }

    public TreeNode buildTree(){
        String rootVal = nodeList.poll();
        if(rootVal.equals("#")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        TreeNode left = buildTree();
        TreeNode right = buildTree();

        root.left = left;
        root.right = right;

        return root;
    }

    TreeNode Deserialize(String str) {
        if(str == null){
            return null;
        }

        String[] nodeVal = str.split(" ");

        for(String s : nodeVal){
            nodeList.add(s);
        }

        TreeNode root = buildTree();
        return root;
    }
}