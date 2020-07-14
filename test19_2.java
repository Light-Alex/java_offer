/**
 * 题目：二进制中1的个数
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * 正数的补码是其本身，负数的补码是反码加1
 * -2的补码: 1000000....0010 -> 1111111....1101 + 1 -> 1111111....1110
 * 方法二：每次 与1进行 与运算(&) 结果为1, count++，然后n向右移一位，总共运算32次
 */
public class test19_2 {
    public static void main(String[] args) {
        int n = -2;
        test19_2 t = new test19_2();
        System.out.println(t.NumberOf1(n));
    }

    public int NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}