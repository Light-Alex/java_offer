import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 题目：丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

/**
 * 方法：
 * 1、定义一个数组array长度为index 用于存放丑数, array[0]置为1，代表第一个丑数
 * 2、定义三个指针分别代表2、3、5, 三个指针初始状态都指向0的位置
 * 3、将三个指针指向的数分别乘以2、3、5, 将结果最小的数添加到数组中，对应的指针向前一步
 * 4、重复上一步，直到数组存满数据，数组中最后一个数(array[index-1])即为第N个丑数
 */
public class test23 {
    public static void main(String[] args) {
        test23 t = new test23();
        // System.out.println(t.minNum(2, 1, -1));
        System.out.println(t.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }

        // int[] array = new int[index];
        // array[0] = 1;
        int twoPointer = 0;
        int threePointer = 0;
        int fivePointer = 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        while(list.size() <= index){
            int minNum = minNum(2 * list.get(twoPointer), 3 * list.get(threePointer), 5 * list.get(fivePointer));
            if(!list.contains(minNum)){
                list.add(minNum);
            }

            if(minNum == 2 * list.get(twoPointer)){
                twoPointer++;
            }else if(minNum == 3 * list.get(threePointer)){
                threePointer++;
            }else{
                fivePointer++;
            }
        }
        return list.get(index-1);
    }

    public int minNum(int a, int b, int c){
        if(a < b){
            if(a < c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b < c){
                return b;
            }else{
                return c;
            }
        }
    }
}