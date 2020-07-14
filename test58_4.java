/**
 * 题目: 数组中重复的数字
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 */

/**
 * 方法四：因为数组中所有数字都在0到n-1的范围内, 所有可以遍历整个数组, 在对应位上的数字加上数组长度length(array[array[i]] += length), 访问某元素时，其 值 % length 表示原来的值, 若索引为该值的元素大于length则表示该数重复了
 */

public class test58_4 {
    public static void main(String[] args) {
        
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        if(numbers == null || length <= 1){
            return false;
        }

        // {2,3,1,0,2,5,3}
        for(int i = 0; i < length; i++){
            // 需要访问的索引(需要加length的索引)
            int index = numbers[i] % length;

            if(numbers[index] >= length){
                duplication[0] = index;
                return true;
            }

            numbers[index] += length;
        }

        return false;
    }
}