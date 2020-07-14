import java.util.Arrays;

/**
 * 题目：二叉搜索树的后序遍历序列
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/**
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）：
   它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
   若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
             8
          /     \
         5       9
       /   \    /
      4     6  7 

后续序列：[4, 6, 5, 7, 9, 8]
 */

/**
 * 方法：分治的思想
 * 后序遍历的序列中，最后一个数字是树的根结点，数组中前面的数字可以分为两部分：
 * 第一部分是左子树结点的值，都比根结点的值小
 * 第二部分是右子树结点的值，都比根结点的值大
 * 然后使用递归分别判断上面两部分是否符合以上原则
 */

public class test29 {
    public static void main(String[] args) {
        
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }

        int len = sequence.length;
        int rootNum = sequence[len - 1];
        int i = 0;
        for(; i < len - 1; i++){
            if(sequence[i] > rootNum){
                break;
            }
        }

        for(int j = i; j < len - 1; j++){
            if(sequence[j] < rootNum){
                return false;
            }
        }

        boolean left = true;
        if(i > 0){
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        boolean right = true;
        if(i < len - 1){
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));
        }

        return left && right;
    }
}