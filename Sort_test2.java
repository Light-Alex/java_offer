import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort_test2 {
    public static void main(String[] args) {
        int[] array = {3, 5, -2, 3, 1, 7, 5};
        int len = array.length;

        System.out.println("=====================================");
        int[] arr = Arrays.copyOf(array, len);
        System.out.println("冒泡排序：");
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("选择排序：");
        printArray(arr);
        selectionSort(arr);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("插入排序：");
        printArray(arr);
        insertSort(arr);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("快速排序：");
        printArray(arr);
        quickSort(arr, 0, len - 1);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("归并排序：");
        printArray(arr);
        mergeSort(arr, 0, len - 1);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("堆排序：");
        printArray(arr);
        heapSort(arr);
        printArray(arr);

        System.out.println("=====================================");
        arr = Arrays.copyOf(array, len);
        System.out.println("桶排序：");
        printArray(arr);
        bucketSort(arr, 3);
        printArray(arr);
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 冒泡排序
    public static void bubbleSort(int[] array){
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // 选择排序
    public static void selectionSort(int[] array){
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < len; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] array){
        int len = array.length;
        for(int i = 1; i < len; i++){
            if(array[i] < array[i-1]){
                int temp = array[i];
                int j = i;
                for(; j > 0 && temp < array[j-1]; j--){
                    array[j] = array[j-1];
                }

                if(j != i){
                    array[j] = temp;
                }

            }
        }
    }

    // 快速排序
    public static void quickSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }

        int first = low;
        int last = high;
        int temp = array[low];

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

    // 归并排序
    public static void mergeSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high) >> 1;

        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high){
        int len = high - low + 1;
        int[] temp = new int[len];

        int left1 = low;
        int left2 = mid + 1;
        int k = 0;

        while(left1 <= mid && left2 <= high){
            temp[k++] = array[left1] < array[left2] ? array[left1++] : array[left2++];
        }

        while(left1 <= mid){
            temp[k++] = array[left1++];
        }

        while(left2 <= high){
            temp[k++] = array[left2++];
        }

        for(int i = 0; i < k; i++){
            array[low + i] = temp[i];
        }
    }

    // 堆排序
    public static void heapSort(int[] array){
        int len = array.length;
        buildMaxHeap(array, len);
        // printArray(array);

        for(int i = len - 1; i > 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, 0, --len);
        }
    }

    // 构建大顶堆
    public static void buildMaxHeap(int[] array, int len){
        for(int i = (len >> 1) - 1; i >= 0; i--){
            // 从最后一个非叶子节点开始往前调整大顶堆
            heapify(array, i, len);
        }
    }

    // 调整大顶堆
    public static void heapify(int[] array, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxIndex = i;

        if(left < len && array[left] > array[maxIndex]){
            maxIndex = left;
        }

        if(right < len && array[right] > array[maxIndex]){
            maxIndex = right;
        }

        if(maxIndex != i){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            // 继续调整孩子节点
            heapify(array, maxIndex, len);
        }
    }

    // 桶排序
    public static void bucketSort(int[] array, int bucketSize){

        int min = array[0];
        int max = array[0];

        for(int i : array){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }

        // 桶的个数
        int bucketCount = (max - min) / bucketSize + 1;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<Integer>());
        }

        for(int i : array){
            buckets.get((i - min) / bucketSize).add(i);
        }

        int k = 0;
        for(int i = 0; i < bucketCount; i++){
            if(buckets.get(i).size() > 0){
                Collections.sort(buckets.get(i));
                for(int num : buckets.get(i)){
                    array[k++] = num;
                }
            }
        }
    }
}