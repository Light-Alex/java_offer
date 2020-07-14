import java.util.ArrayList;
/**
 * 题目：按之字形顺序打印二叉树
 * 题目描述：请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.LinkedList;
import java.util.Stack;

/**
 *             1
 *          /     \
 *         2       3
 *       /   \   /   \
 *      4     5 6     7
 * 
 * result: [[1], [3, 2], [4, 5, 6, 7]]
 */
public class test36 {
    public static void main(String[] args) {
        test36 t = new test36();
        TreeNode t1 = t.new TreeNode(1);
        TreeNode t2 = t.new TreeNode(2);
        TreeNode t3 = t.new TreeNode(3);
        TreeNode t4 = t.new TreeNode(4);
        TreeNode t5 = t.new TreeNode(5);
        TreeNode t6 = t.new TreeNode(6);
        TreeNode t7 = t.new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(t.Print(t1));
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(pRoot);

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        // 层数
        int k = 1;

        while(!nodeList.isEmpty()){
            int width = nodeList.size();

            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();

                // 奇数层
                if(k % 2 != 0){
                    tempList.add(node.val);
                // 偶数层
                }else{
                    stack.push(node.val);
                }

                if(node.left != null){
                    nodeList.add(node.left);
                }

                if(node.right != null){
                    nodeList.add(node.right);
                }
            }

            // 奇数层
            if(k % 2 != 0){
                ArrayList<Integer> copyList = (ArrayList<Integer>) tempList.clone();
                result.add(copyList);
                tempList.clear();
            // 偶数层
            }else{
                while(!stack.isEmpty()){
                    tempList.add(stack.pop());
                }

                ArrayList<Integer> copyList = (ArrayList<Integer>) tempList.clone();
                result.add(copyList);
                tempList.clear();
            }
            
            k++;
        }

        return result;
    }
}