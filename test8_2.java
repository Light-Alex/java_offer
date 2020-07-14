import java.util.ArrayList;
import java.util.List;

/**
 * 题目：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

// 方法二：创建一个新数组, 前面放奇数，后面放偶数

public class test8_2 {
    public static void main(String[] args) {
        test8_2 t = new test8_2();
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
        int[] newArray = new int[array.length];
        int index = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                newArray[index++] = array[i];
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                newArray[index++] = array[i];
            }
        }

        for(int i = 0; i < array.length; i++){
            array[i] = newArray[i];
        }

    }
}