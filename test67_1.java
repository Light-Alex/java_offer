/**
 * 题目: 剪绳子
 * 题目描述：给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * 输入描述：输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述：输出答案。
 * 
 * 示例：
 * 输入: 8
 * 输出: 18
 */

/**
 * 方法：贪心算法
 * 有3就包括3，若target % 3 = 1, 则留出一个3与剩下的余数1组成4，因为4 > 3 * 1
 * target % 3 = 0: result = Math.pow(3, target/3)
 * target % 3 = 1: result = Math.pow(3, target/3 - 1) + 4
 * target % 3 = 2: result = Math.pow(3, target/3) + 2;
 * target < 2: result = 0;
 * target = 2: result = 1;
 * target = 3: result = 2;
 */
public class test67_1 {
    public static void main(String[] args) {
        
    }

    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }

        if(target % 3 == 0){
            return (int) Math.pow(3, target/3);
        }else if(target % 3 == 1){
            return (int) Math.pow(3, target/3-1) * 4;
        }else{
            return (int) Math.pow(3, target/3) * 2;
        }
    }
}