import java.util.ArrayList;
/**
 * 题目：和为S的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 输出描述：对应每个测试案例，输出两个数，小的先输出。
 */

/**
 * 方法：使用左右夹逼法
 * 定义一个两个指针分别指向数组的头和尾, 即left = 0, right = array.length - 1
 * 若array[left] + array[right] > sum, right--
 * 若array[left] + array[right] < sum, left++
 * 若array[left] + array[right] = sum, 则这两个数就是array[left]和array[right](因为这两个数逐渐在向中间靠拢，乘积会越来越大, 所以刚好等于sum时，是两数乘积最小的时候)
 */

public class test52 {
    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array.length < 2){
            return result;
        }

        int left = 0;
        int right = array.length - 1;

        while(left < right){
            int tempSum = array[left] + array[right];
            if(tempSum < sum){
                left++;
            }else if(tempSum > sum){
                right--;
            }else{
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
        }

        return result;
    }
}