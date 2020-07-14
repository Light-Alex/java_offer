import java.util.ArrayList;

/**
 * 题目：最小的K个数 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

/**
 * 方法：构建一个大小为k的大顶堆, 之后每添加一个元素，就与堆顶进行对比，若比堆顶大则不管，若比堆顶小，则替换堆顶，然后对大顶堆进行调整
 * 最终大顶堆中保存的k个元素即为最小的k个数
 */
public class test32 {
    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        // 新建一个链表
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(k > input.length || k < 1){
            return result;
        }

        int[] maxHeap = new int[k];
        for(int i = 0; i < k; i++){
            maxHeap[i] = input[i];
        }

        // 构建大顶堆
        buildMaxHeap(maxHeap, k);

        // 向大顶堆中添加元素(固定长度)
        for(int i = k; i < input.length; i++){
            if(input[i] < maxHeap[0]){
                maxHeap[0] = input[i];
                // 调整大顶堆
                heapify(maxHeap, 0, k);
            }
        }

        // 对大顶堆进行排序
        for(int i = 0; i < k - 1; i++){
            for(int j = 0; j < k - 1 - i; j++){
                if(maxHeap[j] > maxHeap[j+1]){
                    int temp = maxHeap[j];
                    maxHeap[j] = maxHeap[j+1];
                    maxHeap[j+1] = temp;
                }
            }
        }

        // 给链表赋值
        for(int i = 0; i < k; i++){
            result.add(maxHeap[i]);
        }

        return result;
    }

    public void buildMaxHeap(int[] array, int len){
        // 从最后一个非叶子结点向前构建
        for(int i = (len >> 1) - 1; i >= 0; i--){
            heapify(array, i, len);
        }
    }

    // 调整大顶堆
    public void heapify(int[] array, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxIndex = i;

        if(left < len && array[left] > array[maxIndex]){
            maxIndex = left;
        }

        if(right < len && array[right] > array[maxIndex]){
            maxIndex = right;
        }

        if(i != maxIndex){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            heapify(array, maxIndex, len);
        }
    }
}