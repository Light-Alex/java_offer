import java.util.LinkedList;
import java.util.Stack;

/**
 *         1
 *      /     \
 *     2       3
 *   /   \    /
 *  4     5  6
 *       /    \  
 *      7      8
 *       \      \
 *        9      10
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
        TreeNode t8 = t.new TreeNode(8);
        TreeNode t9 = t.new TreeNode(9);
        TreeNode t10 = t.new TreeNode(10);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t5.left = t7;
        t6.right = t8;
        t7.right = t9;
        t8.right = t10;

        /**
         * 先序遍历: {1, 2, 4, 5, 7, 9, 3, 6, 8, 10}
         * 中序遍历: {4, 2, 7, 9, 5, 1, 6, 8, 10, 3}
         * 后序遍历: {4, 9, 7, 5, 2, 10, 8, 6, 3, 1}
         */
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

        // 树的深度：5
        System.out.println("==================");
        System.out.println("树的深度：");
        System.out.println("广度优先：" + tree_3.depthOfTree1(t1));
        System.out.println("深度优先(递归版)：" + tree_3.depthOfTree2(t1));
        System.out.println("深度优先(非递归版)：" + tree_3.depthOfTree3(t1));

        // 值为8的结点的深度和高度: 4, 2
        System.out.println("==================");
        int target = 8;
        System.out.println("广度优先:");
        int[] result = tree_3.depthAndHeight1(t1, target);
        System.out.println("值为" + target + "的结点的深度：" + result[0] + ", " + "高度：" + result[1]);
        System.out.println("------------------");
        System.out.println("深度优先:");
        result = tree_3.depthAndHeight2(t1, target);
        System.out.println("值为" + target + "的结点的深度：" + result[0] + ", " + "高度：" + result[1]);


        // 树的最大宽度不包括中间的null，即每一层的最大结点数 3
        System.out.println("==================");
        System.out.println("树的最大宽度不包括中间的null：" + tree_3.maxWidthOfTreeWithoutNull(t1));
        // 树的最大宽度包括中间的null 7
        System.out.println("树的最大宽度包括中间的null：" + tree_3.maxWidthOfTreeWithNull(t1));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    // 先序遍历(递归版)
    public static void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历(递归版)
    public static void midOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        midOrderRecursive(root.left);
        System.out.println(root.val);
        midOrderRecursive(root.right);
    }

    // 后序遍历(递归版)
    public static void latOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        latOrderRecursive(root.left);
        latOrderRecursive(root.right);
        System.out.println(root.val);
    }

    // 先序遍历(非递归版)-使用栈
    public static void preOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                System.out.println(tempNode.val);
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
            }
        }
    }

    // 中序遍历(非递归版)-使用栈
    public static void midOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(tempNode != null || !nodeList.isEmpty()){
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

    // 后序遍历(非递归版)-使用栈
    public static void latOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;

        while(tempNode != null || !nodeList.isEmpty()){
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

    // 广度优先遍历-使用队列
    public static void breadthFirstSearch(TreeNode root){
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

    // 树的深度-使用广度优先(队列)
    public static int depthOfTree1(TreeNode root){
        int depthOfTree = 0;
        if(root == null){
            return depthOfTree;
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

            depthOfTree++;
        }

        return depthOfTree;
    }

    // 树的深度-使用深度优先(递归版，自下而上)
    public static int depthOfTree2(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depthOfTree2(root.left), depthOfTree2(root.right)) + 1;
    }

    // 树的深度-使用深度优先(非递归版, 使用栈, 自上而下)
    public static int depthOfTree3(TreeNode root){
        int depthOfTree = 0;
        if(root == null){
            return depthOfTree;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;
        int depth = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                depth++;
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    depthOfTree = depth > depthOfTree ? depth : depthOfTree;
                    depth = nodeList.size();
                }
            }
        }

        return depthOfTree;
    }

    // 某个结点的深度和高度-使用广度优先(队列)
    public static int[] depthAndHeight1(TreeNode root, int target){
        int[] result = new int[2];
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        // 树的深度
        int depthOfTree = 0;
        // 结点深度
        int depth = 0;
        // 结点高度
        int height = 0;

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

    // 某个结点的深度和高度-使用深度优先(栈)
    public static int[] depthAndHeight2(TreeNode root, int target){
        int[] result = new int[2];
        if(root == null){
            return result;
        }

        Stack<TreeNode> nodeList = new Stack<TreeNode>();
        TreeNode tempNode = root;
        // 树的高度
        int depthOfTree = 0;
        // 树的当前深度
        int currentDepthOfTree = 0;
        // 结点的深度
        int depth = 0;
        // 结点的高度
        int height = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                currentDepthOfTree++;

                if(tempNode.val == target){
                    depth = currentDepthOfTree;
                }

                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    depthOfTree = currentDepthOfTree > depthOfTree ? currentDepthOfTree : depthOfTree;
                    currentDepthOfTree = nodeList.size();
                }
            }
        }

        height = depthOfTree - depth + 1;
        result[0] = depth;
        result[1] = height;

        return result;
    }

    // 求树的最大宽度不包括中间的null, 即每一层的最大结点数-使用广度优先(队列)
    public static int maxWidthOfTreeWithoutNull(TreeNode root){
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

    // 求树的最大宽度包括中间的null-使用广度优先(队列)
    // 使用一个LinkedList来存结点的下标
    public static int maxWidthOfTreeWithNull(TreeNode root){
        int maxWidth = 0;
        if(root == null){
            return maxWidth;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        LinkedList<Integer> indexList = new LinkedList<Integer>();
        indexList.add(0);

        while(!nodeList.isEmpty()){
            int width = nodeList.size();
            // System.out.println(indexList);
            // indexList中只有一个元素
            if(indexList.size() == 1){
                maxWidth = 1 > maxWidth ? 1 : maxWidth;
            // indexList中有 > 1 个元素
            }else{
                int currentMaxWidth = indexList.get(indexList.size() - 1) - indexList.get(0) + 1;
                maxWidth = currentMaxWidth > maxWidth ? currentMaxWidth : maxWidth;
            }

            for(int i = 0; i < width; i++){
                TreeNode node = nodeList.poll();
                int index = indexList.poll();

                if(node.left != null){
                    nodeList.add(node.left);
                    // 左孩子的索引
                    indexList.add(2 * index + 1);
                }
    
                if(node.right != null){
                    nodeList.add(node.right);
                    // 右孩子的索引
                    indexList.add(2 * index + 2);
                }
            }

        }

        return maxWidth;
    }
}