import java.util.LinkedList;
import java.util.Stack;

/**
 *          1
 *       /     \
 *      2       3
 *    /   \      \
 *   4     5      6
 *        /
 *       7
 */
public class tree_2 {
    public static void main(String[] args) {
        tree_2 t = new tree_2();
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
        t3.right = t6;
        t5.left = t7;

        // 先序遍历: (1, 2, 4, 5, 7, 3, 6)
        // 中序遍历：(4, 2, 7, 5, 1, 3, 6)
        // 后序遍历: (4, 7, 5, 2, 6, 3, 1)
        System.out.println("先序遍历:");
        t.preOrderRecursive(t1);
        System.out.println("-------------");
        t.preOrderStack(t1);
        System.out.println("=============");
        System.out.println("中序遍历:");
        t.midOrderRecursive(t1);
        System.out.println("-------------");
        t.midOrderStack(t1);
        System.out.println("=============");
        System.out.println("后序遍历:");
        t.latOrderRecursive(t1);
        System.out.println("-------------");
        t.latOrderStack(t1);

        // 广度优先遍历: (1, 2, 3, 4, 5, 6, 7)
        System.out.println("=============");
        System.out.println("广度优先遍历:");
        t.breadthFirstSearch(t1);

        // 树的深度：4
        System.out.println("=============");
        System.out.println("树的深度：" + t.depthOfBinaryTree(t1));

        // 值为5的结点的深度和高度: depth: 3, height: 2
        System.out.println("=============");
        int[] result = t.depthAndHeight(t1, 5);
        System.out.println("值为5的结点的深度：" + result[0] + ", " + "值为5的结点的高度：" + result[1]);

        // 二叉树的最大宽度(不包括中间的null)，即每一层中的最多的结点数: 3
        System.out.println("=============");
        System.out.println("二叉树的宽度(不包括中间的null)：" + t.maxWidthWithoutNull(t1));

        // 二叉树的最大宽度(包括中间的null): 4
        System.out.println("=============");
        System.out.println("二叉树的最大宽度(包括中间的null)" + t.maxWidthWithNull(t1));
    }

    class TreeNode {
        TreeNode(int val){
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    // 先序遍历, 递归
    public void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历，递归
    public void midOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        midOrderRecursive(root.left);
        System.out.println(root.val);
        midOrderRecursive(root.right);
    }

    // 后序遍历，递归
    public void latOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        latOrderRecursive(root.left);
        latOrderRecursive(root.right);
        System.out.println(root.val);
    }

    // 先序遍历，非递归版(使用栈)
    public void preOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                System.out.println(tempNode.val);
                nodeList.add(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
            }
        }
    }

    // 中序遍历，非递归版(使用栈)
    public void midOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.add(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                System.out.println(node.val);
                tempNode = node.right;
            }
        }
    }

    // 后序遍历，非递归版(使用栈)
    public void latOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.add(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.peek();
                tempNode = node.right;
                if(tempNode == null){
                    node = nodeList.pop();
                    System.out.println(node.val);
                    while(!nodeList.isEmpty() && node == nodeList.peek().right){
                        node = nodeList.pop();
                        System.out.println(node.val);
                    }
                }
            }
        }
    }

    // 广度优先遍历
    public void breadthFirstSearch(TreeNode root){
        if(root == null){
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            TreeNode node = nodeList.poll();
            System.out.println(node.val);
            if(node.left != null){
                nodeList.add(node.left);
            }
            if(node.right != null){
                nodeList.add(node.right);
            }
        }
    }

    // 求一棵二叉树的深度
    public int depthOfBinaryTree(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                if(node.left != null){
                    nodeList.add(node.left);
                }
                if(node.right != null){
                    nodeList.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 二叉树的深度：从根结点开始数
     * 二叉树的高度：从叶结点开始数
     * 树的深度和高度是相等的
     * 某个结点的深度和高度可能不等(因为开始数的起始位置不同)
     */
    // 求值为5结点的深度和高度
    public int[] depthAndHeight(TreeNode root, int target){
        int depthOfTree = 0;
        int[] result = new int[2];
        int depth = 0;
        int height = 0;
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                if(node.val == target){
                    depth = depthOfTree + 1;
                }
                if(node.left != null){
                    nodeList.add(node.left);
                }
                if(node.right != null){
                    nodeList.add(node.right);
                }
            }
            depthOfTree++;
        }
        height = depthOfTree - depth + 1;

        result[0] = depth;
        result[1] = height;
        return result;
    }

    // 求二叉树的最大宽度(不包括中间的null), 即每一层中的最大结点数
    public int maxWidthWithoutNull(TreeNode root){
        int maxWidth = 0;
        if(root == null){
            return maxWidth;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            maxWidth = width > maxWidth ? width : maxWidth;
            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                if(node.left != null){
                    nodeList.add(node.left);
                }
                if(node.right != null){
                    nodeList.add(node.right);
                }
            }
        }

        return maxWidth;
    }

    /**
     * 求二叉树的最大宽度(包括中间的null)
     * 这个需要用到一个知识点：父结点和左右孩子结点之间索引的关系, 若父结点的索引为i, 则左孩子的索引为2*i+1，右孩子的索引为2*i+2
     * 这样只要记录树每一层的结点的索引，计算出最左结点和最右结点索引的差值，就可计算出这一层的宽度
     * 定义一个整型变量一直保存最大的宽度即可
     * @param root
     * @return
     */
    public int maxWidthWithNull(TreeNode root){
        
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        LinkedList<Integer> nodeIndex = new LinkedList<Integer>();
        nodeList.add(root);
        nodeIndex.add(0);

        int maxWidth = 1;

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
                    nodeIndex.add(2 *index + 2);
                }
            }

            if(nodeIndex.size() >= 2){
                int currentMax = nodeIndex.get(nodeIndex.size() - 1) - nodeIndex.get(0) + 1;
                maxWidth = currentMax > maxWidth ? currentMax : maxWidth;
            }
        }

        return maxWidth;
    }
}