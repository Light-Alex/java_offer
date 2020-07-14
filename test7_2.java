/**
 * 题目：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
   输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
   例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
   NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
方法二：折半查找(二分查找): 最小的数小于左边那个数
if array[mid] > array[right]: left = mid + 1 : 说明最小的数在右边
if array[mid] <= array[left]: right = mid : 说明最小的数在左边或者就是当前这个数
if left = right = mid : 最小的数为 array[mid]
*/

public class test7_2 {
    public static void main(String[] args) {
        test7_2 t = new test7_2();
        int array[] = {3,4,5,1,2};
        System.out.println(t.minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) >> 1;

            if(left == right && left == mid){
                return array[mid];
            }

            if(array[mid] > array[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return array[mid];
    }
}