/**
 * 题目：活动安排问题（动态规划问题）
 * 
 * 题目描述：有8个活动，每个活动的时间段以及得分不同，求怎么安排活动能得到最大的得分（活动安排不能冲突）
 * 
 * 每个活动的时间段和得分
 * 活动1：[1, 4], 5
 * 活动2：[3, 5], 1
 * 活动3：[0, 6], 8
 * 活动4: [4, 7], 4
 * 活动5: [3, 8], 6
 * 活动6: [5, 9], 3
 * 活动7: [6, 10], 2
 * 活动8: [8, 11], 4
 */

/**
 * 求解：使用动态规划的思想求解，先求出通用表达式
 * 该问题就是一个选或不选的问题(选和不选，最优解就是两者中最大的)
 * OPT(i) = max(vi + OPT(prev(i)), OPT(i-1)) (vi是当前活动的得分，prev(i)是做当前任务的话，前面能做的最近活动的下标)
 * v = {5, 1, 8, 4, 6, 3, 2, 4}
 * prev = {0, 0, 0, 1, 0, 2, 3, 5}
 * 
 * 从前往后计算，直到求出OPT(8)
 * OPT(1) = max(5 + OPT(0), OPT(0)) = 5
 * OPT(2) = max(1 + OPT(0), OPT(1)) = 5
 * OPT(3) = max(8 + OPT(0), OPT(2)) = 8
 * ...
 * OPT(8) = max(v8 + OPT(5), OPT(7))
 * 
 * 参考链接：https://www.bilibili.com/video/BV18x411V7fm
 */
public class activity {
    public static void main(String[] args) {
        int[] value = {5, 1, 8, 4, 6, 3, 2, 4};
        int[] prev = {0, 0, 0, 1, 0, 2, 3, 5};
        int n = 8;

        activity a = new activity();
        int result = a.optimize(value, prev, n);
        System.out.println(result);
    }

    /**
     * 
     * @param value 每个活动的得分
     * @param prev 做当前任务的话，前面能做的最近活动的下标
     * @param n 安排的活动总数
     * @return result 最大得分
     */
    public int optimize(int[] value, int[] prev, int n){
        int result = 0;

        // 保存已得到的最优解
        int[] opt = new int[n+1];
        opt[0] = result;

        for(int i = 0; i < n; i++){
            result = Math.max(value[i] + opt[prev[i]], result);
            opt[i+1] = result;
        }

        return result;
    }
}