import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：滑动窗口的最大值
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， 
 * {2,[3,4,2],6,2,5,1}， 
 * {2,3,[4,2,6],2,5,1}， 
 * {2,3,4,[2,6,2],5,1}， 
 * {2,3,4,2,[6,2,5],1}， 
 * {2,3,4,2,6,[2,5,1]}。
 */

/**
 * 方法一：
 * 实现一个求最大值的函数, 同时使用Arrays.copyOfRange(T[] original, int from, int to), 将滑动窗口内的数组传入求大值函数中，求得一个最大值, 将最大值添加到列表中
 */

public class test64_1 {
    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(num.length < 1 || size > num.length || size < 1){
            return result;
        }

        int len = num.length;
        for(int i = 0; i < len - size + 1; i++){
            result.add(maxNum(Arrays.copyOfRange(num, i, i + size)));
        }

        return result;
    }

    public int maxNum(int[] array){
        int result = array[0];
        for(int i : array){
            if(i > result){
                result = i;
            }
        }
        return result;
    }
}