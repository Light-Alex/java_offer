/**
 * 题目：连续子数组的最大和
 * 题目描述：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */

/**
 * 方法二：时间复杂度O(n)
 * 用total记录累加值, maxSum记录最大值
 * 若前几项累加的和为负数，则认为有害于总和, total重新记为当前值，否则继续累加
 * maxSum总是保存当前最大值
 */

public class test40_2 {
    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        test40_2 t = new test40_2();
        System.out.println(t.FindGreatestSumOfSubArray(array));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length < 1){
            return (Integer) null;
        }

        int maxSum = array[0];
        int total = array[0];

        for(int i = 1; i < array.length; i++){
            if(total < 0){
                total = array[i];
            }else{
                total += array[i];
            }

            maxSum = total > maxSum ? total : maxSum;
        }

        return maxSum;
    }
}