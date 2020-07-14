import java.util.Stack;

/**
 * 题目：用两个栈实现一个队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */


public class test6 {
    // Stack类型的引用变量
    // stack1用来接收数据
    // stack2用来对stack1中的数据进行倒转然后输出, stack2中是队列的形式
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        test6 t = new test6();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        t.push(5);
        System.out.println(t.pop());
        System.out.println(t.pop());
    }

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }
}