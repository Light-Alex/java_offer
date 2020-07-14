/**
 * 题目：斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
 * n<=39
 */

// 方式二：保留前两次结果，时间复杂度为n

public class test1_2 {
    public static void main(String[] args) {
        test1_2 t = new test1_2();
        System.out.println(t.Fibonacci(37));
    }

    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int a = 0;
        int b = 1;
        int ret = 0;

        for(int i = 1; i < n; i++){
            ret = a + b;
            a = b;
            b = ret;
        }

        return ret;
    }
}