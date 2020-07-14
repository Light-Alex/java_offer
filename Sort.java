// 排序(从小到大排序)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Sort {
    public static void main(String[] args) {
        int[] array = {3, 1, -1, 5, 3, 6, 4, -2};
        int result[];
        // 冒泡排序
        result = Sort.bubbleSort(array);
        System.out.println("冒泡排序: ");
        Sort.printArray(result);

        // 选择排序
        result = Sort.selectionSort(array);
        System.out.println("选择排序: ");
        Sort.printArray(result);

        // 插入排序
        result = Sort.insertSort(array);
        System.out.println("插入排序：");
        Sort.printArray(result);

        // 快速排序
        int[] arr = Arrays.copyOf(array, array.length);
        Sort.quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序：");
        Sort.printArray(arr);

        // 堆排序
        arr = Arrays.copyOf(array, array.length);
        Sort.heapSort(arr);
        System.out.println("堆排序：");
        Sort.printArray(arr);

        // 归并排序
        arr = Arrays.copyOf(array, array.length);
        Sort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序：");
        Sort.printArray(arr);

        // 桶排序
        arr = Arrays.copyOf(array, array.length);
        Sort.bucketSort(arr, 3);
        System.out.println("桶排序：");
        Sort.printArray(arr);
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个
     * 2、对每一对相邻元素做同样的工作，从开始第一对到结尾最后一对。这步做完后，最后的元素会是最大的数
     * 3、针对所有的元素重复以上步骤，除了最后一个
     * 4、持续每次针对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     */
    public static int[] bubbleSort(int[] array){
        int[] arr = Arrays.copyOf(array, array.length);

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * 选择排序
     * 1、在未排序的序列中找到最小的元素，存放到排序序列的起始位置
     * 2、从剩余未排序元素中继续寻找最小的元素，然后放到已排序序列的末尾
     * 3、以此类推，直到所有元素均排序完毕
     */
    public static int[] selectionSort(int[] array){
        int[] arr = Arrays.copyOf(array, array.length);

        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    /**
     * 插入排序
     * 1、从第一个元素开始，该元素可以认为已经被排序
     * 2、取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3、如果该元素(已排序)大于新元素，将该元素移到下一个位置
     * 4、重复步骤3，直到找到已排序的元素小于或等于新元素的位置
     * 5、将新元素插入该位置后
     * 6、重复步骤2~5
     */
    public static int[] insertSort(int[] array){
        int[] arr = Arrays.copyOf(array, array.length);

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                int temp = arr[i];
                for(int j = i; j >= 0; j--){
                    if(j > 0 && temp < arr[j-1]){
                        arr[j] = arr[j-1];
                    }else{
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }

        return arr;
    }

    /**
     * 快速排序
     * 1、选取第一个数作为基准
     * 2、将比基准小的数交换到前面，比基准大的数交换到后面
     * 3、对左右区间重复第二步，直到各区间只有一个数
     */
    public static void quickSort(int[] array, int low, int high){

        if(low >= high){
            return;
        }

        int first = low;
        int last = high;
        int temp = array[first];

        while(first < last){
            while(first < last && array[last] >= temp){
                last--;
            }
            if(first < last){
                array[first++] = array[last];
            }

            while(first < last && array[first] <= temp){
                first++;
            }
            if(first < last){
                array[last--] = array[first];
            }
        }

        array[first] = temp;

        quickSort(array, low, first - 1);
        quickSort(array, first + 1, high);
    }

    /**
     * 堆排序
     * 1、将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
     * 2、将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
     * 3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
     */

    public static void heapSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }

        int len = array.length;

        // 构建大顶堆
        buildMaxHeap(array, len);

        // 交换堆顶和当前末尾元素，重置大顶堆
        for(int i = len - 1; i > 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            len--;
            heapify(array, 0, len);
        }
    }

    public static void buildMaxHeap(int[] array, int len){
        // 从最后一个非叶子结点向前遍历，调整结点性质，使之成为一个大顶堆
        for(int i = len / 2 - 1; i >= 0; i--){
            heapify(array, i, len);
        }
    }

    public static void heapify(int[] array, int i, int len){
        // 根据堆的性质找出左右结点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 默认当前结点(父结点)是最大值
        int maxIndex = i;

        if(left < len && array[left] > array[maxIndex]){
            // 如果有左结点，并且左结点的值更大，更新最大值的索引
            maxIndex = left;
        }

        if(right < len && array[right] > array[maxIndex]){
            // 如果有右结点，并且右结点的值更大，更新最大值的索引
            maxIndex = right;
        }

        // 如果最大值的索引不是父结点的索引，则交换父结点和最大值结点
        if(maxIndex != i){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            // 互换后，子结点的值发生了变化，如果子结点也有自己的子结点，则需要进行调整
            heapify(array, maxIndex, len);
        }
    }

    /**
     * 归并排序
     * 1、分解(Divide)：将n个元素分成2个含n/2个元素的子序列
     * 2、解决(Conquer)：用合并排序法对两个子序列递归的排序
     * 3、合并(combine)：合并两个已排序的子序列得到最终的结果
     */
    public static void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int mid = ((right - left) >> 1) + left;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = 0;
        int left1 = left;
        int left2 = mid + 1;

        // 比较左右两部分的元素，哪个小，就把那个元素填入temp数组中
        while(left1 <= mid && left2 <= right){
            temp[i++] = array[left1] < array[left2] ? array[left1++] : array[left2++];
        }

        // 将剩余的元素依次填入temp数组中
        while(left1 <= mid){
            temp[i++] = array[left1++];
        }
        while(left2 <= right){
            temp[i++] = array[left2++];
        }

        // 把最终的排序结果复制给原数组
        for(i = 0; i < temp.length; i++){
            array[left + i] = temp[i];
        }
    }

    /**
     * 桶排序
     * 1、设置一个桶存放范围(上限与下限的差值)为bucketSize，则一共需要(max - min) / bucketSize + 1个桶，加1，最后那个桶才能包括max元素
     * 2、则每个桶的范围为：[min, min + bucketSize), [min + bucketSize, 2 * bucketSize), ...[(max - min) / bucketSize * bucketSize, ((max - min) / bucketSize + 1) * bucketSize]
     * 3、遍历数组，将元素一个一个放到对应的桶中
     * 4、对每个不是空的桶进行排序
     * 5、从不是空的桶中把元素再放回原来的数组中
     */
    public static void bucketSort(int[] array, int bucketSize){
        if(array.length <=1 || array == null || bucketSize < 1){
            return;
        }

        // 找数组中最大值和最小值，计算数组总的范围，以此确定需要的桶的数量
        int max = array[0];
        int min = array[0];

        for(int i : array){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        // 需要的桶的数目
        int bucketCount = (max - min) / bucketSize + 1;

        // 定义桶，每个桶内定义一个列表，用于存放在这个桶范围内的元素
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucketCount);
        for(int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<Integer>());
        }
        
        // 将array数组中的元素放入对应范围的桶中
        for(int i : array){
            int index = (i - min) / bucketSize;
            buckets.get(index).add(i);
        }

        int k = 0;
        // 对每个桶中元素进行排序，并将排序好的元素输出到原数组中，输出完成，则原数组排序完成
        for(int i = 0; i < buckets.size(); i++){
            if(buckets.get(i).size() > 1){
                Collections.sort(buckets.get(i));
            }
            if(buckets.get(i).size() > 0){
                for(int num : buckets.get(i)){
                    array[k++] = num;
                }
            }
        }
    }
}