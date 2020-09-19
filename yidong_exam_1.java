import java.util.Scanner;

/**
 * 题目：计数器游戏
 * 
 * 题目描述：
 * Louise和Richard玩一个游戏。他们有一个初值设置为 N 的计数器。Louise先开始游戏，此后两人轮流进行。 在游戏中，他们进行如下操作：
   如果 N 不是 2 的幂，他们把计数器减少小于 N 的最大2的幂。
   如果 N 是 2 的次方，他们把计数器减少 N 的一半。
   得到结果作为新的 N 值，再继续进行以后的操作。
   当计数器值减到 1 的时候，即 N == 1，游戏结束。最后一个进行合法操作的人获得胜利。 给定 N ， 你的任务是求出游戏的获胜者。
 */

public class yidong_exam_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count; i++){
            long num = sc.nextLong();
            int times = 0;
            while(num != 1){
                double temp = Math.log(num) / Math.log(2);
                if(temp == (int) temp){
                    num = num / 2;
                }else{
                    num -= Math.pow(2, (int) temp);
                }
                times++;
            }
            if(times % 2 == 0){
                System.out.println("Richard");
            }else{
                System.out.println("Louise");
            }
        }
    }


}