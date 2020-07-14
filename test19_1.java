/**
 * 题目：二进制中1的个数
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * 正数的补码是其本身，负数的补码是反码加1
 * -2的补码: 1000000....0010 -> 1111111....1101 + 1 -> 1111111....1110
 * 方法一：使用Integer.toBinaryString()，将一个整型转化成二进制字符串，然后统计里面1的个数
 */
public class test19_1 {
    public static void main(String[] args) {
        int n = -2;
        test19_1 t = new test19_1();
        System.out.println(t.NumberOf1(n));
    }

    public int NumberOf1(int n) {
        String binStr = Integer.toBinaryString(n);
        char[] c = binStr.toCharArray();
        int count = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '1'){
                count++;
            }
        }
        return count;
    }
}