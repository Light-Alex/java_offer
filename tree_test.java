import java.util.LinkedList;
import java.util.Stack;

/*
        1
     /    \
    2      3
  /   \     \
 4     5     6
        \
         7
*/

public class tree_test {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.right = t7;

        /**
         * 先序遍历：[1, 2, 4, 5, 7, 3, 6]
         * 中序遍历：[4, 2, 5, 7, 1, 6, 3]
         * 后序遍历：[4, 7, 5, 2, 6, 3, 1]
         * 广度优先：[1, 2, 3, 4, 5, 6, 7]
         */

        System.out.println("=============================");
        System.out.println("先序遍历：");
        System.out.println("递归版：");
        preOrderRecursive(t1);
        System.out.println("非递归版：");
        preOrderStack(t1);

        System.out.println("=============================");
        System.out.println("中序遍历：");
        System.out.println("递归版：");
        midOrderRecursive(t1);
        System.out.println("非递归版：");
        midOrderStack(t1);

        System.out.println("=============================");
        System.out.println("后序遍历：");
        System.out.println("递归版：");
        latOrderRecursive(t1);
        System.out.println("非递归版：");
        latOrderStack(t1);

        System.out.println("=============================");
        System.out.println("广度优先：");
        breathFirstSearch(t1);

        System.out.println("=============================");
        System.out.println("树的深度：");
        System.out.println("递归版，自底向上: " + depthOfTree1(t1));

        System.out.println("=============================");
        System.out.println("树的深度：");
        System.out.println("非递归版，深度优先，自上而下: " + depthOfTree2(t1));

        System.out.println("=============================");
        System.out.println("树的深度：");
        System.out.println("非递归版，广度优先，自上而下: " + depthOfTree3(t1));

        System.out.println("=============================");
        int target = 5;
        System.out.println("指定节点的深度和高度：");
        System.out.println("深度优先，先序遍历: " + depthAndHeight1(t1, target)[0] + " " + depthAndHeight1(t1, target)[1]);
        System.out.println("指定节点的深度和宽度（广度优先）: " + depthAndHeight2(t1, target)[0] +  " " + depthAndHeight2(t1, target)[1]);

        System.out.println("=============================");
        System.out.println("二叉树的最大宽度，不包括中间的null: " + maxWidthOfTree1(t1));
        System.out.println("求二叉树的最大宽度，包括中间的null: " + maxWidthOfTree2(t1));
    }

    // 先序遍历（递归版）
    public static void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历（递归版）
    public static void midOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        midOrderRecursive(root.left);
        System.out.println(root.val);
        midOrderRecursive(root.right);
    }

    // 后序遍历（递归版）
    public static void latOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }

        latOrderRecursive(root.left);
        latOrderRecursive(root.right);
        System.out.println(root.val);
    }

    // 先序遍历（非递归版）
    public static void preOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<>();
        TreeNode tempNode = root;

        while(tempNode != null || !nodeList.isEmpty()){
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

    // 中序遍历（非递归版）
    public static void midOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<>();
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

    // 后序遍历（非递归版）
    public static void latOrderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> nodeList = new Stack<>();
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

    // 广度优先遍历
    public static void breathFirstSearch(TreeNode root){
        if(root == null){
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            TreeNode tempNode = nodeList.poll();
            System.out.println(tempNode.val);

            if(tempNode.left != null){
                nodeList.add(tempNode.left);
            }

            if(tempNode.right != null){
                nodeList.add(tempNode.right);
            }
        }

    }

    // 树的深度（递归版，自底向上）
    public static int depthOfTree1(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(depthOfTree1(root.left), depthOfTree1(root.right)) + 1;
    }

    // 树的深度（非递归版，深度优先，自上而下）
    public static int depthOfTree2(TreeNode root){
        int depthOfTree = 0;
        if(root == null){
            return depthOfTree;
        }

        Stack<TreeNode> nodeList = new Stack<>();
        TreeNode tempNode = root;
        int depth = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.push(tempNode);
                tempNode = tempNode.left;
                depth++;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    depthOfTree = depthOfTree > depth ? depthOfTree : depth;
                    depth = nodeList.size();
                }
            }
        }

        return depthOfTree;
    }

    // 树的深度（非递归版，广度优先，自上而下）
    public static int depthOfTree3(TreeNode root){
        int depthOfTree = 0;
        if(root == null){
            return depthOfTree;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int count = nodeList.size();
            for(int i = 0; i < count; i++){
                TreeNode tempNode = nodeList.poll();
                if(tempNode.left != null){
                    nodeList.add(tempNode.left);
                }
                if(tempNode.right != null){
                    nodeList.add(tempNode.right);
                }
            }
            depthOfTree++;
        }

        return depthOfTree;
    }

    // 指定节点的深度和宽度（深度优先，先序遍历）
    public static int[] depthAndHeight1(TreeNode root, int target){
        int[] depthAndHeight = new int[2];
        if(root == null){
            return depthAndHeight;
        }

        Stack<TreeNode> nodeList = new Stack<>();
        TreeNode tempNode = root;
        int depth = 0;

        while(tempNode != null || !nodeList.isEmpty()){
            if(tempNode != null){
                nodeList.add(tempNode);
                depth++;
                if(tempNode.val == target){
                    depthAndHeight[0] = depth;
                }
                tempNode = tempNode.left;
            }else{
                TreeNode node = nodeList.pop();
                tempNode = node.right;
                if(tempNode == null){
                    depthAndHeight[1] = depthAndHeight[1] > depth ? depthAndHeight[1] : depth;
                    depth = nodeList.size();
                }
            }
        }

        depthAndHeight[1] = depthAndHeight[1] - depthAndHeight[0] + 1;

        return depthAndHeight;
    }

    // 指定节点的深度和宽度（广度优先）
    public static int[] depthAndHeight2(TreeNode root, int target){
        int[] depthAndHeight = new int[2];
        if(root == null){
            return depthAndHeight;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int depth = 0;

        while(!nodeList.isEmpty()){
            int count = nodeList.size();
            for(int i = 0; i < count; i++){
                TreeNode tempNode = nodeList.poll();
                if(tempNode.val == target){
                    depthAndHeight[0] = depth + 1;
                }
                if(tempNode.left != null){
                    nodeList.add(tempNode.left);
                }
                if(tempNode.right != null){
                    nodeList.add(tempNode.right);
                }
            }
            depth++;
        }

        depthAndHeight[1] = depth - depthAndHeight[0] + 1;
        return depthAndHeight;
    }

    // 求二叉树的最大宽度，不包括中间的null
    public static int maxWidthOfTree1(TreeNode root){
        int maxWidthOfTree = 0;
        if(root == null){
            return maxWidthOfTree;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        while(!nodeList.isEmpty()){
            int count = nodeList.size();
            maxWidthOfTree = maxWidthOfTree > count ? maxWidthOfTree : count;
            for(int i = 0; i < count; i++){
                TreeNode tempNode = nodeList.poll();
                if(tempNode.left != null){
                    nodeList.add(tempNode.left);
                }
                if(tempNode.right != null){
                    nodeList.add(tempNode.right);
                }
            }
        }

        return maxWidthOfTree;
    }

    // 求二叉树的最大宽度，包括中间的null
    public static int maxWidthOfTree2(TreeNode root){
        int maxWidthOfTree = 0;
        if(root == null){
            return maxWidthOfTree;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        LinkedList<Integer> indexList = new LinkedList<>();
        indexList.add(0);
        maxWidthOfTree = 1;

        while(!nodeList.isEmpty()){
            int count = nodeList.size();

            if(indexList.size() > 1){
                maxWidthOfTree = maxWidthOfTree > indexList.get(count-1) - indexList.get(0) + 1 ? maxWidthOfTree : indexList.get(count-1) - indexList.get(0) + 1;
            }

            for(int i = 0; i < count; i++){
                TreeNode tempNode = nodeList.poll();
                int index = indexList.poll();
                if(tempNode.left != null){
                    nodeList.add(tempNode.left);
                    indexList.add(2 * index + 1);
                }
                if(tempNode.right != null){
                    nodeList.add(tempNode.right);
                    indexList.add(2 * index + 2);
                }
            }
        }

        return maxWidthOfTree;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}