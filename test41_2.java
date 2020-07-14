/**
 * 题目: 矩形覆盖
 * 题目描述：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

/**
 * 方法：
 * 大矩形的长为n宽为2, 设总的放法有f(n)种
 * 当第一块矩形竖着放时，有f(n-1)种放法，当第一块矩形横着放时，有f(n-2)种放法, 所以f(n) = f(n-1) + f(n-2)
 * f(1) = 1, f(2) = 2
 * 就是一个斐波那契数列
 * 
 * 非递归版
 */
public class test41_2 {
    public static void main(String[] args) {
        
    }

    public int RectCover(int target) {
        if(target < 1){
            return 0;
        }

        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int result = 0;

        for(int i = 2; i < target; i++){
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}