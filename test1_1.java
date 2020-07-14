/**
 * 题目：斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
 * n<=39
 */

// 方式一：递归实现, 时间复杂度为2^n

    
public class test1_1 {
    public static void main(String[] args) {
        test1_1 t = new test1_1();
        int n = 37;
        System.out.println(t.Fibonacci(n));
    }

    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}