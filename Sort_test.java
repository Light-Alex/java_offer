import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort_test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 1, -4, 5, 7, 6, -4, 1};
        int[] arr = Arrays.copyOf(array, array.length);
        System.out.println("冒泡排序：");
        BubbleSort(arr);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("选择排序: ");
        selectionSort(arr);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("插入排序：");
        insertSort(arr);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("快速排序：");
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("堆排序：");
        heapSort(arr);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("归并排序：");
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.println("桶排序：");
        bucketSort(arr, 3);
        printArray(arr);
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("===============================");
    }

    // 冒泡排序
    public static void BubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
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
        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = minIndex; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i+1] < array[i]){
                int temp = array[i+1];
                for(int j = i + 1; j >= 0; j--){
                    if(j > 0 && temp < array[j-1]){
                        array[j] = array[j-1];
                    }else{
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int first = left;
        int last = right;
        int temp = array[left];

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

        quickSort(array, left, first - 1);
        quickSort(array, first + 1, right);
    }

    // 堆排序
    public static void heapSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        // 构建大顶堆
        buildMaxHeap(array, array.length);
        int len = array.length;
        // 把大顶堆的堆顶依次与当前的最后一个元素交换，交换后调整大顶堆
        for(int i = array.length - 1; i > 1; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, --len);
        }
    }

    // 构建大顶堆
    public static void buildMaxHeap(int[] array, int len){
        // 从最后一个非叶子结点开始往前构建
        for(int i = (len >> 1) - 1; i >= 0; i--){
            // 调整堆
            heapify(array, i, len);
        }
    }

    // 调整堆
    public static void heapify(int[] array, int i, int len){
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int maxIndex = i;

        if(leftChild < len && array[leftChild] > array[maxIndex]){
            maxIndex = leftChild;
        }

        if(rightChild < len && array[rightChild] > array[maxIndex]){
            maxIndex = rightChild;
        }

        if(i != maxIndex){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            // 若maxIndex有孩子结点，则需要继续调整
            heapify(array, maxIndex, len);
        }
    }

    // 归并排序
    public static void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        // 注意
        int mid = ((right - left) >> 1) + left;

        // 归
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        // 并
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        if(left >= right){
            return;
        }

        int[] newArray = new int[right - left + 1];
        int left1 = left;
        int left2 = mid + 1;

        int index = 0;
        while(left1 <= mid && left2 <= right){
            newArray[index++] = array[left1] < array[left2] ? array[left1++] : array[left2++];
        }

        while(left1 <= mid){
            newArray[index++] = array[left1++];
        }

        while(left2 <= right){
            newArray[index++] = array[left2++];
        }

        for(int i = 0; i < newArray.length; i++){
            array[left + i] = newArray[i];
        }
    }

    // 桶排序
    public static void bucketSort(int[] array, int bucketSize){
        if(array == null || array.length <= 1){
            return;
        }

        int maxNum = array[0];
        int minNum = array[0];

        for(int i : array){
            if(i > maxNum){
                maxNum = i;
            }
            if(i < minNum){
                minNum = i;
            }
        }

        // 桶的个数
        int bucketCount = (maxNum - minNum) / bucketSize + 1;
        // 创建桶
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<Integer>());
        }
        
        // 数字装入对应的桶
        for(int i : array){
            buckets.get((i - minNum) / bucketSize).add(i);
        }

        // 对每个桶里的数字排序，再输出到原来的数组中
        int k = 0;
        for(ArrayList<Integer> list : buckets){
            if(list.size() > 0){
                // 排序
                Collections.sort(list);
                // 出桶
                for(int i = 0; i < list.size(); i++){
                    array[k++] = list.get(i);
                }
            }
        }
    }
}