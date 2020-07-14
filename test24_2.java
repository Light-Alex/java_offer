import java.util.HashMap;
/**
 * 题目：数组中只出现一次的数字 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import javax.tools.ForwardingJavaFileObject;

/**
 * 方法二：异或的方法
 * 异或的性质：两个相同数字异或=0，一个数和0异或还是它本身
 * 
 * 数组中只有一个数只出现一次，其余的数都出现两次：可以将数组中的这些数依次异或，最终的结果就是数组中只出现一次的数(成对的数都被异或抵消掉了，异或满足交换律)
 * 
 * 数组中有两个数（A、B）只出现一次，其余的数都出现两次：可以将数组中的这些数依次异或，最终的结果就是 那两个只出现一次的数的异或结果，找出异或结果二进制中第一个1的位置(A、B不同的位)，
 * 根据这个位置为0还是为1可将原数组一分为二，成对的数 + A在一组，成对的数 + B在一组，分别对这两个数组中的每个元素依次进行异或运算，得到得两个异或结果即为A和B
 */
public class test24_2 {
    public static void main(String[] args) {
        
    }

    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        if(array.length < 2){
            return;
        }

        int xorNum = 0;

        for(int i : array){
            xorNum = xorNum ^ i;
        }

        int index = 0;

        // 找出异或结果二进制中第一个1的位置(A、B不同的位)
        while(xorNum % 2 == 0){
            index++;
            xorNum = xorNum >> 1;
        }

        index = 1 << index;

        for(int i : array){
            // 二进制中index位置处为0的分组
            if((index & i) == 0){
                num1[0] = num1[0] ^ i;
            }else{ // 二进制中index位置处为1的分组
                num2[0] = num2[0] ^ i;
            }
        }
    }
}