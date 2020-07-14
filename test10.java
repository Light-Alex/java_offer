import java.util.Stack;

/**
 * 题目：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

/**
 * 创建一个栈
 * 按压入顺序将元素压入栈
 * 每次压入栈后循环判断，是否需要弹出栈
 * 弹出栈的条件是：栈顶元素和弹出序列对应的元素相等
 */

public class test10 {
    Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        test10 t = new test10();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(t.IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int [] pushA, int [] popA) {
        if(pushA.length != popA.length || pushA.length < 1){
            return false;
        }

        int index = 0;

        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }

        return index == popA.length ? true : false;
    }
}