import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *         t1
 *      /     \
 *    t2       t3
 *   /  \     /  \
 * t4    t5 t6    t7
 *            \
 *             t8
 * 
 * 二叉树的遍历：
 * 1、深度优先
 * - 先序遍历: 根左右 (1, 2, 4, 5, 3, 6, 8, 7)
 * - 中序遍历：左根右 (4, 2, 5, 1, 6, 8, 3, 7)
 * - 后序遍历：左右根 (4, 5, 2, 8, 6, 7, 3, 1)
 * 2、广度优先
 */
public class tree {
    public static void main(String[] args) {
        tree t = new tree();

        TreeNode t1 = t.new TreeNode(1);
        TreeNode t2 = t.new TreeNode(2);
        TreeNode t3 = t.new TreeNode(3);
        TreeNode t4 = t.new TreeNode(4);
        TreeNode t5 = t.new TreeNode(5);
        TreeNode t6 = t.new TreeNode(6);
        TreeNode t7 = t.new TreeNode(7);
        TreeNode t8 = t.new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t6.right = t8;

        t.preOrderRecursive(t1);
        System.out.println("====================");
        t.midOrderRecursive(t1);
        System.out.println("====================");
        t.latOrderRecursive(t1);

        System.out.println("=============================");

        t.preOrderStack(t1);
        System.out.println("====================");
        t.midOrderStack(t1);
        System.out.println("====================");
        t.latOrderStack(t1);

        System.out.println("=============================");

        t.breadFirstSearch(t1);
    }

    class TreeNode {
        TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 递归
    // 先序遍历
    public void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历
    public void midOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        midOrderRecursive(root.left);
        System.out.println(root.val);
        midOrderRecursive(root.right);
    }

    // 后序遍历
    public void latOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        latOrderRecursive(root.left);
        latOrderRecursive(root.right);
        System.out.println(root.val);
    }

    // 非递归版(使用栈)
    // 先序遍历
    public void preOrderStack(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!stack.isEmpty() || tempNode != null){
            if(tempNode != null){
                System.out.println(tempNode.val);
                stack.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = stack.pop();
                tempNode = node.right;
            }
        }
    }

    // 中序遍历
    public void midOrderStack(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!stack.isEmpty() || tempNode != null){
            if(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = stack.pop();
                System.out.println(node.val);
                tempNode = node.right;
            }
        }
    }

    // 后序遍历
    public void latOrderStack(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!stack.isEmpty() || tempNode != null){
            if(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = stack.peek();
                tempNode = node.right;
                if(tempNode == null){
                    node = stack.pop();
                    System.out.println(node.val);
                    while(!stack.isEmpty() && node == stack.peek().right){
                        node = stack.pop();
                        System.out.println(node.val);
                    }
                }
            }
        }
    }

    // 广度优先搜索
    public void breadFirstSearch(TreeNode root){
        // ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return;
        }

        // 创建一个队列
        Queue<TreeNode> nodeList = new LinkedList<TreeNode>();

        nodeList.add(root);
        while(!nodeList.isEmpty()){
            TreeNode currentNode = nodeList.poll();
            System.out.println(currentNode.val);

            if(currentNode.left != null){
                nodeList.add(currentNode.left);
            }

            if(currentNode.right != null){
                nodeList.add(currentNode.right);
            }
        }
    }
}