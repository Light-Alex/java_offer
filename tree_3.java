import java.util.LinkedList;
import java.util.Stack;

/**
 *          1
 *        /   \
 *       2     3
 *     /   \    \
 *    4     5    6
 *          /
 *         7
 */

public class tree_3 {
    public static void main(String[] args) {
        tree_3 t = new tree_3();
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
        // 中序遍历: (4, 2, 7, 5, 1, 3, 6)
        // 后序遍历: (4, 7, 5, 2, 6, 3, 1)
        System.out.println("先序遍历：");
        System.out.println("递归版：");
        tree_3.preOrderRecursive(t1);
        System.out.println("------------------");
        System.out.println("非递归版：");
        tree_3.preOrderStack(t1);

        System.out.println("==================");
        System.out.println("中序遍历：");
        System.out.println("递归版：");
        tree_3.midOrderRecursive(t1);
        System.out.println("------------------");
        System.out.println("非递归版：");
        tree_3.midOrderStack(t1);

        System.out.println("==================");
        System.out.println("后序遍历：");
        System.out.println("递归版：");
        tree_3.latOrderRecursive(t1);
        System.out.println("------------------");
        System.out.println("非递归版：");
        tree_3.latOrderStack(t1);

        // 树的深度：4
        System.out.println("==================");
        System.out.println("树的深度：");
        System.out.println("广度优先：" + tree_3.depthOfTree1(t1));
        System.out.println("深度优先(递归版)：" + tree_3.depthOfTree2(t1));
        System.out.println("深度优先(非递归版)：" + tree_3.depthOfTree3(t1));

        // 值为5的结点的深度和宽度: 3, 2
        System.out.println("==================");
        int target = 5;
        int[] result = tree_3.depthAndHeight(t1, target);
        System.out.println("值为" + target + "的结点的深度：" + result[0] + ", " + "高度：" + result[1]);

        // 树的最大宽度不包括中间的null，即每一层的最大结点数
        System.out.println("==================");
        System.out.println("树的最大宽度不包括中间的null：" + tree_3.maxWidthOfTreeWithoutNull(t1));
        // 树的最大宽度包括中间的null
        System.out.println("树的最大宽度包括中间的null：" + tree_3.maxWidthOfTreeWithNull(t1));
    }

    class TreeNode{
        TreeNode(int val){
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    // 先序遍历，递归版
    public static void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历，递归版
    public static void midOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        midOrderRecursive(root.left);
        System.out.println(root.val);
        midOrderRecursive(root.right);
    }

    // 后序遍历，递归版
    public static void latOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        latOrderRecursive(root.left);
        latOrderRecursive(root.right);
        System.out.println(root.val);
    }

    // 先序遍历，非递归版(使用栈)
    public static void preOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                System.out.println(tempNode.val);
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
            }
        }
    }

    // 中序遍历，非递归版(使用栈)
    public static void midOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                System.out.println(node.val);
                tempNode = node.right;
            }
        }
    }

    // 后序遍历，非递归版(使用栈)
    public static void latOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.peek();
                tempNode = node.right;
                if(tempNode == null){
                    node = nodeList.pop();
                    System.out.println(node.val);
                    while(!nodeList.isEmpty() && nodeList.peek().right == node){
                        node = nodeList.pop();
                        System.out.println(node.val);
                    }
                }
            }
        }
    }

    // 广度优先遍历
    public static void breadthFirstSearch(TreeNode root){
        if(root == null){
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
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

    // 树的深度, 广度优先
    public static int depthOfTree1(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();

            for(int i = 0; i < width; i++){
                TreeNode currentNode = nodeList.poll();

                if(currentNode.left != null){
                    nodeList.add(currentNode.left);
                }
                if(currentNode.right != null){
                    nodeList.add(currentNode.right);
                }
            }

            depth++;
        }

        return depth;
    }

    // 树的深度，深度优先(递归)
    public static int depthOfTree2(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depthOfTree2(root.left), depthOfTree2(root.right)) + 1;
    }

    // 树的深度，深度优先(非递归版)，使用先序遍历
    public static int depthOfTree3(TreeNode root){
        if(root == null){
            return 0;
        }

        int depth = 0;
        int maxDepth = 1;

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(!nodeList.isEmpty() || tempNode != null){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
                depth++;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    maxDepth = depth > maxDepth ? depth : maxDepth;
                    depth = nodeList.size();
                }
            }
        }

        return maxDepth;
    }
    
    // 求某个结点的深度和高度，用广度优先
    public static int[] depthAndHeight(TreeNode root, int target){
        int[] result = new int[2];
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        int depthOfTree = 0;
        int depth = 0;
        int height = 0;

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode currentNode = nodeList.poll();
                if(currentNode.val == target){
                    depth = depthOfTree + 1;
                }

                if(currentNode.left != null){
                    nodeList.add(currentNode.left);
                }
                if(currentNode.right != null){
                    nodeList.add(currentNode.right);
                }
            }
            depthOfTree++;
        }

        height = depthOfTree - depth + 1;
        result[0] = depth;
        result[1] = height;

        return result;
    }

    // 求树的最大宽度(不包括中间的null)，即每一层的最大结点数，使用广度优先
    public static int maxWidthOfTreeWithoutNull(TreeNode root){
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        int maxWidth = 0;

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            maxWidth = width > maxWidth ? width : maxWidth;

            for(int i = 0; i < width; i++){
                TreeNode currentNode = nodeList.poll();
                if(currentNode.left != null){
                    nodeList.add(currentNode.left);
                }
                if(currentNode.right != null){
                    nodeList.add(currentNode.right);
                }
            }
        }

        return maxWidth;
    }

    // 求树的最大宽度(包括中间的null), 需要知道父结点和子结点之间的索引关系
    public static int maxWidthOfTreeWithNull(TreeNode root){
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        LinkedList<Integer> nodeIndex = new LinkedList<Integer>();
        nodeIndex.add(0);

        int maxWidth = 1;

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            for(int i = 0; i < width; i++){
                TreeNode currentNode = nodeList.poll();
                int index = nodeIndex.poll();

                if(currentNode.left != null){
                    nodeList.add(currentNode.left);
                    nodeIndex.add(2 * index + 1);
                }

                if(currentNode.right != null){
                    nodeList.add(currentNode.right);
                    nodeIndex.add(2 * index + 2);
                }
            }

            if(nodeIndex.size() >= 2){
                int currentWidth = nodeIndex.get(nodeIndex.size() - 1) - nodeIndex.get(0) + 1;
                maxWidth = currentWidth > maxWidth ? currentWidth : maxWidth;
            }
        }

        return maxWidth;
    }
}