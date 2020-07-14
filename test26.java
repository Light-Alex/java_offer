/**
 * 题目：树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * 方法：递归
 *                      8               2
                     /     \          /   \
                    8       7        4     7
                  /   \ 
                 9     2
                     /   \
                    4     7
 */
public class test26 {
    public static void main(String[] args) {
        test26 t = new test26();
        TreeNode t11 = t.new TreeNode(8);
        TreeNode t12 = t.new TreeNode(8);
        TreeNode t13 = t.new TreeNode(7);
        TreeNode t14 = t.new TreeNode(9);
        TreeNode t15 = t.new TreeNode(2);
        TreeNode t16 = t.new TreeNode(4);
        TreeNode t17 = t.new TreeNode(7);
        t11.left = t12;
        t11.right = t13;
        t12.left = t14;
        t12.right = t15;
        t15.left = t16;
        t15.right = t17;

        TreeNode t21 = t.new TreeNode(2);
        TreeNode t22 = t.new TreeNode(4);
        TreeNode t23 = t.new TreeNode(7);
        t21.left = t22;
        t21.right = t23;

        System.out.println(t.HasSubtree(t11, t21));
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return false;
        }

        boolean result = false;

        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoesTree1haveTree2(root1, root2);
            }
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        
        return result;
    }

    public boolean DoesTree1haveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        return DoesTree1haveTree2(root1.left, root2.left) && DoesTree1haveTree2(root1.right, root2.right);
    }

    class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}