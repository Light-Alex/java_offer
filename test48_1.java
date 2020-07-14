/**
 * 题目：数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数。
 */

/**
 * 方法一：遍历整个数组, 时间复杂度O(n)
 */
public class test48_1 {
    public static void main(String[] args) {
        
    }

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;

        for(int i : array){
            if(i == k){
                count++;
            }
        }

        return count;
    }
}