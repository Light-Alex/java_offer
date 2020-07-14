import java.util.LinkedList;
import java.util.Queue;
// 题目：求二叉树的最大宽度
// 方法：广度优先，每次遍历树的一层
/**
 * 构建二叉树
 *          1
 *       2     3
 *    4   5   6  7
 * 8
 *
 * @param args
*/
public class WidthOfTree {
    public static void main(String[] args) {
        WidthOfTree w = new WidthOfTree();
        TreeNode t1 = w.new TreeNode(1);
        TreeNode t2 = w.new TreeNode(2);
        TreeNode t3 = w.new TreeNode(3);
        TreeNode t4 = w.new TreeNode(4);
        TreeNode t5 = w.new TreeNode(5);
        TreeNode t6 = w.new TreeNode(6);
        TreeNode t7 = w.new TreeNode(7);
        TreeNode t8 = w.new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right= t5;
        // t3.left = t6;
        t3.right = t7;
        t4.left = t8;

        // 二叉树最大的结点数(针对每一层)
        System.out.println("二叉树最大的结点数(针对每一层)：" + w.maxNumOfTree(t1));
        // 二叉树最大宽度
        System.out.println("二叉树最大宽度：" + w.maxWidth(t1));
    }

    class TreeNode {
        TreeNode(int val){
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }


    // 二叉树最大的结点数(针对每一层)
    public int maxNumOfTree(TreeNode root){
        int maxWidth = 0;
        int width;

        Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            width = nodeList.size();
            maxWidth = maxWidth > width ? maxWidth : width;

            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                if(node.left!=null){
                    nodeList.add(node.left);
                }
                if(node.right!=null){
                    nodeList.add(node.right);
                }
            }
        }

        return maxWidth;
    }


    // 二叉树的最大宽度, 使用广度优先遍历
    /**
     * 二叉树，父结点和子结点的索引的关系, 若父结点索引为i，则左孩子结点的索引为2*i+1，右孩子索引为2*i+2, 通过记录这一层中，最左边的结点的索引(a)和最右边结点的索引(b)，可以求出二叉树的最大宽度b-a+1
     * @param root
     * @return
     */
    public int maxWidth(TreeNode root){
        int maxWidth = 0;
        if(root == null){
            return maxWidth;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        LinkedList<Integer> nodeIndex = new LinkedList<Integer>();

        nodeList.add(root);
        nodeIndex.add(0);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();

            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                int index = nodeIndex.poll();

                if(node.left != null){
                    nodeList.add(node.left);
                    nodeIndex.add(2 * index + 1);
                }
                if(node.right != null){
                    nodeList.add(node.right);
                    nodeIndex.add(2 * index + 2);
                }
            }
            if(nodeIndex.size() >= 2){
                int currentMax = nodeIndex.get(nodeIndex.size()-1) - nodeIndex.get(0) + 1;
                maxWidth =  currentMax > maxWidth ? currentMax : maxWidth;
            }
        }

        return maxWidth;
    }
}