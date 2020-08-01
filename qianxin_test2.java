import java.util.ArrayList;

/**
 * 题目：找亲戚
 * 
 * 题目描述： 如果一个正整数可以被7整除，我们称之为亲7数。对于给出的一组个位数字，请找出使用所有数字排列出的数字中的亲7数的个数。
 * 
 * 其中给出的个位数字数组中每一个都是不相关的，可能有重复的数字，如：{1, 1, 2}，排列出的数为{112, 121, 112, 121, 211,
 * 211}， 亲7数为{112, 112}共两个
 * 
 * 输入：个位数字数组，数组有m个元素[x1, x2, x3, ..., xm](0=<xi<=9) 输出：亲7数的个数
 * 
 * 示例： 输入：[1, 1, 2] 输出：2
 */

public class test2 {

    public static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] arr = {1, 1 ,2};
        int ret = test2.reletive_7(arr);
        System.out.println(ret);
    }

    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    public static int reletive_7 (int[] digit) {
        int ret = 0;
        if(digit == null || digit.length < 1){
            return ret;
        }

        perum(digit, 0, digit.length-1);

        for(int i : result){
            if(i % 7 == 0){
                ret++;
            }
        }

        return ret;
    }


    /**
     * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
       例如：将 数组 { 1，2，3}进行全排列
       首先，我们需要知道当只有一个元素进行全排列的时候，全排列就等于它本身。
       这个数组的全排列就是需要将 每个元素放到数组首部，然后将剩下的元素进行全排列，依照此思路我们可以用递归很快的写出代码。
       如果需要全排列按照字典序输出的话，只需要将需要全排列的数组先进行排序，然后再求全排列就好。
       可能本人的描述理解起来有点困难，整体思想就是将这个数组里面的每个元素都放在第一位一次，将剩下的元素进行全排列，层层递归，直至只有一个元素为止。
       这里推荐一个B站UP主：“正月点灯笼” 。他的算法视频大多都通俗易懂，在这里再次感谢！！！
       参考链接：https://www.cnblogs.com/songjinzhao/p/11440806.html
     */
    // 对数组元素进行全排列
    public static void perum(int[] arr, int p, int q){
        // 递归结束条件
        if(p == q){
//            printArray(arr);
            int temp = 0;
            int len = arr.length;
            for(int i = 0; i < arr.length; i++){
                temp += arr[i] * Math.pow(10, --len);
            }
            result.add(temp);
        }

        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        for(int i = p; i <= q; i++){
            swap(arr, i, p);
            // 把剩下的元素都做全排列。
            perum(arr, p + 1, q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。（回溯）
            swap(arr, i, p);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}