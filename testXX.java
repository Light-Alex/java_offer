import java.util.ArrayList;

/**
 *          1
 *        /   \
 *       2     3
 *     /      /
 *    4      5
 * 
 *         1
 *       /   \ 
 *      3     2
 *       \     \
 *        5     4
 */
public class testXX {
    public static void main(String[] args) {
        // ArrayList<Integer> a = new ArrayList<Integer>();
        // a.add(1);
        // a.add(2);
        // a.add(3);
        // ArrayList<Integer> b = (ArrayList<Integer>) a.clone();

        ArrayList<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        ArrayList<String> b = (ArrayList<String>) a.clone();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

        System.out.println(a.get(0).hashCode());
        System.out.println(b.get(0).hashCode());
        System.out.println(a.get(0) == b.get(0));

        System.out.println(System.identityHashCode(a.get(0)));
        System.out.println(System.identityHashCode(b.get(0)));

        a.remove(1);
        System.out.println(a);
        System.out.println(b);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    } 

    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }
}