import java.util.ArrayList;
import java.util.List;

/**
 * 题目：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

// 方法一：创建一个ArrayList, add()添加元素, get()获取元素, set()设置元素, remove()删除元素，前面放奇数，后面放偶数

public class test8_1 {
    public static void main(String[] args) {
        test8_1 t = new test8_1();
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
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                list.add(array[i]);
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                list.add(array[i]);
            }
        }

        for(int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }

    }
}