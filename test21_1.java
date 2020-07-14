import java.util.HashMap;

/**
 * 题目：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

// 方法一：使用HashMap(类似字典)统计每个数字出现的次数，输出 出现次数大于数组长度一半 的数(如果有的话)
public class test21_1 {
    public static void main(String[] args) {
        test21_1 t = new test21_1();
        int[] array = {1,2,3,2,2,2,5,4,2};
        t.MoreThanHalfNum_Solution(array);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i : array){
            if(!dict.containsKey(i)){
                dict.put(i, 1);
            }else{
                dict.put(i, dict.get(i) + 1);
            }
        }

        // System.out.println(dict);

        for(int i : dict.keySet()){
            if(dict.get(i) > array.length / 2){
                return i;
            }
        }
        return 0;
    }
}