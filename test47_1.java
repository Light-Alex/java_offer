/**
 * 题目：数组中的逆序对
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
    数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
    对于%100的数据,size<=2*10^5
    
    例子：
    输入：1,2,3,4,5,6,7,0
    输出：7
    逆序对: (1, 0) (2, 0) (3, 0) (4, 0) (5, 0) (6, 0) (7, 0)
 */

/**
 * 方法一：遍历每一种组合, 出现逆序对total + 1, 时间复杂度: O(n^2)，复杂度过大
 */
public class test47_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        test47_1 t = new test47_1();
        System.out.println(t.InversePairs(array));
    }

    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1){
            return 0;
        }

        long total = 0;

        for(int i = 0; i < array.length - 1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    total++;
                }
            }
        }

        return (int) (total % 1000000007);
    }
}