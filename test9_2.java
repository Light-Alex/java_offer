import java.util.Stack;

/**
 * 题目：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */

// 方法二：用空间换时间，创建一个新的栈，栈顶永远放最小的值，长度<=原栈相等
// 注意：该方式只有 添加元素<新栈栈顶元素时 才将该元素压入新栈，出栈时当 新栈栈顶元素=原栈栈顶元素时 新栈的栈顶元素才出栈

public class test9_2 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        
    }

    // 压栈
    public void push(int node){
        stack1.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }else{
            // stack2.peek()访问栈顶元素
            if(stack2.peek() > node){
                stack2.push(node);
            }
        }
    }

    // 出栈
    public void pop() {
        if(!stack1.empty() && !stack2.empty()){
            if(stack1.peek() == stack2.peek()){
                stack2.pop();
            }
            stack1.pop();
        }
    }

    // 访问栈顶元素
    public int top() {
        if(stack1.empty()){
            // null
            return (Integer)null;
        }
        return stack1.peek();
    }

    // 获取最小值
    public int min() {
        if(stack2.empty()){
            // null
            return (Integer)null;
        }
        return stack2.peek();
    }
}