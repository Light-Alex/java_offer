/**
 * 题目: 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

/**
 * 青蛙最后可以剩1级台阶没跳，或2级台阶没跳，或3级台阶没跳...或n-1级台阶没跳, 或n级台阶没跳，所以
 * f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0)
 * f(n-1) = f(n-2) + f(n-3) + ... + f(1) + f(0)
 * 所以f(n) = 2f(n-1) = 2 * 2f(n-2) = 2^(n-1)f(1) = 2^(n-1)
 * f(1) = 1
 * f(0) = 1
 */

// 方式二：自己求2^(n-1)

public class test3_2 {
    public static void main(String[] args) {
        test3_2 t = new test3_2();
        System.out.println(t.JumpFloorII(3));
    }

    public int JumpFloorII(int target) {
        if(target < 1){
            return 0;
        }
        
        int ret = 1;
        for(int i = 1; i < target; i++){
            ret = ret * 2;
        }

        return ret;
    }
}