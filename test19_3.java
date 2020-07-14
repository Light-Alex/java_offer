/**
 * 题目：二进制中1的个数
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * 正数的补码是其本身，负数的补码是反码加1
 * -2的补码: 1000000....0010 -> 1111111....1101 + 1 -> 1111111....1110
 * 方法三：n & (n - 1): 每次会将最后一个1置为0
 */
public class test19_3 {
    public static void main(String[] args) {
        int n = -2;
        test19_3 t = new test19_3();
        System.out.println(t.NumberOf1(n));
    }

    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}