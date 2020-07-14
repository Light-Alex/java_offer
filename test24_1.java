import java.util.HashMap;
/**
 * 题目：数组中只出现一次的数字 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

// 方法一：使用HashMap，统计数组中每个数字出现的次数，输出只出现一次的数字
public class test24_1 {
    public static void main(String[] args) {
        
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2){
            return;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i], 1);
            }else{
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            }
        }

        int[] num = new int[2];
        int k = 0;

        for(int i : hashMap.keySet()){
            if(hashMap.get(i) == 1){
                num[k++] = i;
            }
        }

        num1[0] = num[0];
        num2[0] = num[1];
    }
}