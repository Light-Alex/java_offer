import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 题目：Marks and Toys
 * 
 * 题目描述：
 * Mark和Jane生完第一个孩子后非常高兴。他们的儿子喜欢玩具，所以Mark想买一些玩具。 
 * 他面前摆着许多不同的玩具，上面标有它们的价格。 Mark只花了一定的钱，他想用这笔钱最大程度地购买玩具。
   给定价格清单和消费金额，Mark最多可以购买多少个玩具？
   例如，如果prices= [1,2,3,4]并且Mark有k = 7可以花费，则他可以用6个货币单位购买玩具[1,2,3]，
   或用7个货币单位购买玩具[3,4]。他将选择第一个包含3个玩具的组。
 */
public class yidong_exam_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int total = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < count; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int result = 0;
        for(int i : list){
            total -= i;
            if(total >= 0){
                result++;
            }else{
                break;
            }
        }
        System.out.println(result);
    }
}