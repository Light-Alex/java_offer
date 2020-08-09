import java.util.HashMap;

/**
 * 题目：和为目标值的最大数目不重叠非空子数组数目
 * 
 * 题目描述：给你一个数组 nums 和一个整数 target 。
   请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。

   示例1：
   输入：nums = [1,1,1,1,1], target = 2
   输出：2
   解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
   
   示例2：
   输入：nums = [-1,3,5,1,4,2,-9], target = 6
   输出：2
   解释：总共有 3 个子数组和为 6 。
   ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。

 */

/**
 * 方法：前缀和问题，使用一个字典保存前面数字的和，如果当前的和sum - target 的结果在字典中出现过（表示除去前面和sum，剩余数字的和等于target），表示出现了和为target的子数组，count++，
 * 然后sum置为0，字典置为{0=1}，目的是除去数组重叠的情况，0表示当前和刚好和target相等
 */
public class leetcode_4 {
    public static void main(String[] args) {
        int[] nums = {-1,3,5,1,4,2,-9};
        leetcode_4 ll = new leetcode_4();
        System.out.println(ll.maxNonOverlapping(nums, 6));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - target)){
                count++;
                sum = 0;
                map = new HashMap<Integer, Integer>(); 
            }
            map.put(sum, 1);
        }

        return count;
    }
}