/**
 * 题目：不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

/**
 * 不使用加减乘除做加法则考虑用位运算
 * 加法有两个操作：
 * 1、每个位上的对应数字相加，先不进位(异或运算^)得xorNum
 * 2、加上进位的数值(与运算&后向左移动一位)得andNum
 * 3、怎么实现加操作，循环执行异或运算^和与运算&，直到与运算的结果为0(andNum = 0), 即没有进位，加法操作完成
 */
public class test20 {
    public static void main(String[] args) {
        test20 t = new test20();
        System.out.println(t.Add(-1, -2));
    }

    public int Add(int num1, int num2) {
        int xorNum = num1 ^ num2;
        int andNum = (num1 & num2) << 1;
        while(andNum != 0){
            num1 = xorNum;
            num2 = andNum;
            xorNum = num1 ^ num2;
            andNum = (num1 & num2) << 1;
        }
        return xorNum;
    }
}