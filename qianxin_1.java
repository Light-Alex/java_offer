import java.util.Stack;

/**
 * 题目：反转栈
 */

public class qianxin_1 {

    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        qianxin_1 q = new qianxin_1();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        System.out.println(stack);
        q.reverseStack();
        System.out.println(stack);
    }

    public void push(Integer num){
        stack.push(num);
    }

    public Integer pop(){
        return stack.pop();
    }

    // 获取栈底值并移除
    private Integer getLastValue(){
        int value = stack.pop();
        if(stack.isEmpty()){
            return value;
        }else{
            // 递归
            int last = getLastValue();
            // 重新压入数值
            stack.push(value);
            return last;
        }
    }

    // 通过递归重新把栈底值反转压入
    public void reverseStack(){
        if(stack.isEmpty()){
            return;
        }

        int last = getLastValue();
        reverseStack();
        stack.push(last);
    }
}