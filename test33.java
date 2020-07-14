import java.util.ArrayList;

/**
 * 题目：数据流中的中位数
 * 题目描述：如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

/**
 * 方法：
 * 1、使用一个最大堆放较小的数和一个最小堆放较大的数来进行处理
 * 2、最大堆和最小堆依次添加数据：
 *   - 在往最大堆添加数据时，若该数字比最小堆的根元素大，则与最小堆的根元素交换，调整最小堆，再将交换前最小堆的根元素添加到最大堆；否则直接将该数字插入最大堆
 *   - 在往最小堆添加数据时，若该数字比最大堆的根元素小，则与最大堆的根元素交换，调整最大堆，再将交换前最大堆的根元素添加到最小堆；否则直接将该数字插入最小堆
 * 5、最终：
 *   - 若最大堆和最小堆长度相等，则中位数为最大堆和最小堆根元素的平均数
 *   - 若最大堆长度大于最小堆，则中位数为最大堆根元素
 */
public class test33 {

    ArrayList<Integer> maxHeap = new ArrayList<Integer>();
    ArrayList<Integer> minHeap = new ArrayList<Integer>();

    public static void main(String[] args) {
        // {5,2,3,4,1,6,7,0,8}
        int[] array = {5,2,3,4,1,6,7,0,8};
        test33 t = new test33();
        for(int i : array){
            t.Insert(i);
            System.out.println(t.maxHeap);
            System.out.println(t.minHeap);
            System.out.println("----------------");
        }
        // System.out.println(t.maxHeap);
        // System.out.println(t.minHeap);
    }

    public void Insert(Integer num) {
        // 先往大顶堆插入数据
        if(maxHeap.size() == minHeap.size()){
            // 这是第一次插入数据，直接插入大顶堆
            if(maxHeap.size() == 0){
                maxHeap.add(num);
                buildMaxHeap(maxHeap, maxHeap.size());
            }else{
                // 如果插入的数字比小顶堆的根元素大，则与小顶堆的根元素交换，调整小顶堆，将交换后的数插入大顶堆
                if(num > minHeap.get(0)){
                    int temp = minHeap.get(0);
                    minHeap.set(0, num);
                    heapifyMinHeap(minHeap, 0, minHeap.size());

                    maxHeap.add(temp);
                    buildMaxHeap(maxHeap, maxHeap.size());
                // 否则直接插入大顶堆
                }else{
                    maxHeap.add(num);
                    buildMaxHeap(maxHeap, maxHeap.size());
                }
            }
        // 往小顶堆插入数据
        }else{
            // 如果插入的数字小于了大顶堆的根顶元素, 则与大顶堆的根顶元素交换，调整大顶堆，将交换后的数字插入小顶堆
            if(num < maxHeap.get(0)){
                int temp = maxHeap.get(0);
                maxHeap.set(0, num);
                heapifyMaxHeap(maxHeap, 0, maxHeap.size());

                minHeap.add(temp);
                buildMinHeap(minHeap, minHeap.size());
            // 否则直接插入小顶堆
            }else{
                minHeap.add(num);
                buildMinHeap(minHeap, minHeap.size());
            }
        }
    }

    public Double GetMedian() {
        return maxHeap.size() == minHeap.size() ? ((double) maxHeap.get(0).intValue() + minHeap.get(0).intValue()) / 2 : (double) maxHeap.get(0).intValue();
    }

    // 构建大顶堆
    public void buildMaxHeap(ArrayList<Integer> array, int len){
        // 从最后一个非叶子结点向前构建
        for(int i = (len >> 1) - 1; i >= 0; i--){
            heapifyMaxHeap(array, i, len);
        }
    }

    // 调整大顶堆
    public void heapifyMaxHeap(ArrayList<Integer> array, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxIndex = i;

        if(left < len && array.get(left) > array.get(maxIndex)){
            maxIndex = left;
        }

        if(right < len && array.get(right) > array.get(maxIndex)){
            maxIndex = right;
        }

        if(maxIndex != i){
            int temp = array.get(i);
            array.set(i, array.get(maxIndex));
            array.set(maxIndex, temp);

            // maxIndex结点的值发生改变，若该结点还有子结点，则继续进行调整
            heapifyMaxHeap(array, maxIndex, len);
        }
    }

    // 构建小顶堆
    public void buildMinHeap(ArrayList<Integer> array, int len){
        // 从最后一个非叶子节点开始往前调整小顶堆
        for(int i = (len >> 1) - 1; i >= 0; i--){
            heapifyMinHeap(array, i, len);
        }
    }

    // 调整小顶堆
    public void heapifyMinHeap(ArrayList<Integer> array, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;

        if(left < len && array.get(left) < array.get(minIndex)){
            minIndex = left;
        }

        if(right < len && array.get(right) < array.get(minIndex)){
            minIndex = right;
        }

        if(i != minIndex){
            int temp = array.get(i);
            array.set(i, array.get(minIndex));
            array.set(minIndex, temp);

            // minIndex结点的值发生变化, 若该结点还有孩子结点，则继续进行调整
            heapifyMinHeap(array, minIndex, len);
        }
    }
}