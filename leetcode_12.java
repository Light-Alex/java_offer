import java.util.HashMap;
import java.util.Stack;

/**
 * 题目：有效的括号
 * 
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

   有效字符串需满足：

   左括号必须用相同类型的右括号闭合。
   左括号必须以正确的顺序闭合。
   注意空字符串可被认为是有效字符串。

   示例1：
   输入: "()"
   输出: true

   示例2：
   输入: "()[]{}"
   输出: true
   
   示例3：
   输入: "([)]"
   输出: false

   示例4：
   输入: "([)]"
   输出: false

   示例5：
   输入: "{[]}"
   输出: true
 */

/**
 * 方法：使用栈
 */

public class leetcode_12 {
    public static void main(String[] args) {
        String s = "(([]){})";
        leetcode_12 ll = new leetcode_12();
        System.out.println(ll.isValid(s));
    }

    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}