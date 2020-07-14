import java.util.ArrayList;
import java.util.List;

/**
 * 题目：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

// 方法三：使用冒泡排序，若左边为偶数，右边为奇数，则交换这两个数

public class test8_3 {
    public static void main(String[] args) {
        test8_3 t = new test8_3();
        int[] array = {3, -1, 4, 2, 5, 7};
        // System.out.println(array);
        // for(int i = 0; i < array.length; i++){
        //     System.out.print(array[i] + " ");
        // }
        t.reOrderArray(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public void reOrderArray(int [] array) {
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] % 2 == 0 && array[j+1] % 2 != 0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}