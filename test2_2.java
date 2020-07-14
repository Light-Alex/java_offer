/**
 * 题目：跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */

/**sheng
 * 类似斐波那契数列，青蛙最后只可能剩1级台阶没跳，或2级台阶没跳
 * 剩1级台阶没跳的跳法有: f(n-1)种
 * 剩2级台阶没跳的跳法有: f(n-2)种
 * 所有总共的跳法有f(n) = f(n-1) + f(n-2)
 * f(1) = 1
 * f(2) = 2
 */

// 保存前两次结果的值，时间复杂度为O(n)

public class test2_2 {
    public static void main(String[] args) {
        test2_2 t = new test2_2();
        System.out.println(t.JumpFloor(3));
    }
    
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int ret = 0;

        for(int i = 2; i < target; i++){
            ret = a + b;
            a = b;
            b = ret;
        }

        return ret;
    }
}