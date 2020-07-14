/**
 * 题目：数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数。
 */

/**
 * 方法二：因为是排好序的数组，所以可以使用折半查找, 时间复杂度O(log2n)
 */
public class test48_2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3,4,5};
        int k = 3;
        test48_2 t = new test48_2();
        System.out.println(t.GetNumberOfK(array, k));
    }

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if(array == null || array.length < 1){
            return count;
        }

        int left = 0;
        int right = array.length - 1;
        int mid = -1;

        while(left <= right){
            mid = (left + right) >> 1;

            if(k > array[mid]){
                left = mid + 1;
            }else if(k < array[mid]){
                right = mid - 1;
            }else{
                count++;
                break;
            }
        }

        // 如果左右两端还有则继续查找
        if(count != 0){
            left = mid + 1;
            right = mid - 1;
            while(left <= array.length - 1 && array[left] == k){
                count++;
                left++;
            }

            while(right >= 0 && array[right] == k){
                count++;
                right--;
            }
        }

        return count;
    }
}