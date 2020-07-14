/**
 * 题目：左旋转字符串
 * 题目描述：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */

/**
 * 方法：找出变化前和变化后，字符串中的下标对应关系
 * 设变化前下标为preIndex, 变化后的下标为latIndex，字符串长度为length，左移n位，则
 * latIndex = (preIndex - n % length + length) % length
 */

public class test53 {
    public static void main(String[] args) {
        
    }

    public String LeftRotateString(String str, int n) {
        if(str == null || str.length() < 1){
            return "";
        }

        int length = str.length();
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[length];

        for(int i = 0; i < length; i++){
            newCharArray[(i - n % length + length) % length] = charArray[i];
        }

        return String.valueOf(newCharArray);
    }
}