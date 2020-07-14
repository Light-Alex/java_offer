import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
/**
 * 题目：二叉树中和为某一值的路径
 * 题目描述：输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *           8
          /     \
         5       9
       /   \    /
      4     8  2
              /
             2
输入: 21
输出: [[8, 9, 2, 2], [8, 5, 8]]
 */

/**
 * 方法：使用广度优先算法
 * 定义三个列表：
 * 一个存放结点(队列)，一个存放路径(二维列表)，一个存放结果(二维列表)
 */
public class test30 {
    public static void main(String[] args) {
        test30 t = new test30();
        TreeNode t1 = t.new TreeNode(8);
        TreeNode t2 = t.new TreeNode(5);
        TreeNode t3 = t.new TreeNode(9);
        TreeNode t4 = t.new TreeNode(4);
        TreeNode t5 = t.new TreeNode(8);
        TreeNode t6 = t.new TreeNode(2);
        TreeNode t7 = t.new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t6.left = t7;

        System.out.println(t.FindPath(t1, 21));
    }

    class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

        nodeList.add(root);
        ArrayList<Integer> pathEach = new ArrayList<Integer>();
        pathEach.add(root.val);
        path.add(pathEach);

        while(!nodeList.isEmpty()){
            TreeNode currentNode = nodeList.poll();
            ArrayList<Integer> currentPath = path.get(0);

            if(currentNode.left == null && currentNode.right ==null){
                if(Sum(currentPath) == target){
                    result.add(0, currentPath);
                }
            }

            path.remove(0);

            if(currentNode.left != null){
                nodeList.add(currentNode.left);
                ArrayList<Integer> copyCurrentPath = new ArrayList<Integer>();
                for(int i = 0; i < currentPath.size(); i++){
                    copyCurrentPath.add(currentPath.get(i));
                }
                copyCurrentPath.add(currentNode.left.val);
                path.add(copyCurrentPath);
            }

            if(currentNode.right != null){
                nodeList.add(currentNode.right);
                ArrayList<Integer> copyCurrentPath = new ArrayList<Integer>();
                for(int i = 0; i < currentPath.size(); i++){
                    copyCurrentPath.add(currentPath.get(i));
                }
                copyCurrentPath.add(currentNode.right.val);
                path.add(copyCurrentPath);
            }
        }

        return result;
    }

    public int Sum(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
}