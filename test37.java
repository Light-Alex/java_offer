import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：把二叉树打印成多行
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

/**
 *             1
 *          /     \
 *         2       3
 *       /   \   /   \
 *      4     5 6     7
 * 
 * result: [[1], [2, 3], [4, 5, 6, 7]]
 * 
 * 方法：广度优先遍历
 */
public class test37 {
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

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(pRoot);
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                tempList.add(node.val);

                if(node.left != null){
                    nodeList.add(node.left);
                }

                if(node.right != null){
                    nodeList.add(node.right);
                }
            }

            ArrayList<Integer> copyList = (ArrayList<Integer>) tempList.clone();
            result.add(copyList);
            tempList.clear();
        }

        return result;
    }
}