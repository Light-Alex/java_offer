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
 * 方法二：使用归并排序，合并的时候统计逆序对的数目
 * 
 *                   1,2,3,4,5,6,7,0]
                   /                 \
              [1,2,3,4]          [5,6,7,0]
              /        \          /      \
            [1,2]    [3,4]      [5,6]   [7,0]
            /   \    /   \      /   \   /   \
          [1]   [2][3]   [4]  [5]   [6][7]  [0]
 */
public class test47_2 {
    long total;
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,0,7};
        test47_2 t = new test47_2();
        System.out.println(t.InversePairs(array));
    }

    public int InversePairs(int[] array) {
        if(array == null || array.length <= 1){
            return 0;
        }

        mergeSort(array, 0, array.length - 1);

        return (int)(total % 1000000007);
    }

    // 归
    public void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int mid = ((right - left) >> 1) + left;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    // 并
    public void merge(int[] array, int left, int mid, int right){
        if(left >= right){
            return;
        }

        int[] tempArray = new int[right - left + 1];
        int left1 = left;
        int left2 = mid + 1;
        int k = 0;

        while(left1 <= mid && left2 <= right){
            if(array[left1] < array[left2]){
                tempArray[k++] = array[left1];
                left1++;
            }else{
                // 每次合并，两边都是排好序的，所以只用看左边那部分就好，看左边有多少个元素大于右边那个元素
                total += mid - left1 + 1;
                tempArray[k++] = array[left2];
                left2++;
            }
        }

        // 添加剩余元素
        while(left1 <= mid){
            tempArray[k++] = array[left1++];
        }

        while(left2 <= right){
            tempArray[k++] = array[left2++];
        }

        // 给原数组赋值
        for(int i = 0; i < tempArray.length; i++){
            array[left + i] = tempArray[i];
        }
    }
}