import java.util.Arrays;

public class Sort_1 {
    public static void main(String[] args) {
        int array[] = {3, 2, 1, -1, -2, 2, 4, 8, 5};
        int[] arr = Arrays.copyOf(array, array.length);

        System.out.print("冒泡排序：");
        Sort_1.bubbleSort(arr);
        Sort_1.printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.print("选择排序：");
        Sort_1.selectionSort(arr);
        Sort_1.printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.print("插入排序：");
        Sort_1.insertSort(arr);
        Sort_1.printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.print("快速排序：");
        Sort_1.quickSort(arr, 0, arr.length - 1);
        Sort_1.printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.print("堆排序： ");
        Sort_1.heapSort(arr);
        Sort_1.printArray(arr);

        arr = Arrays.copyOf(array, array.length);
        System.out.print("归并排序：");
        Sort_1.mergeSort(arr, 0, arr.length - 1);
        Sort_1.printArray(arr);
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 冒泡排序
    public static void bubbleSort(int[] array){
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
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            if(i != minIndex){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                int temp = array[i];
                for(int j = i; j >= 0; j--){
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
    public static void quickSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }

        int left = low;
        int right = high;
        int temp = array[low];

        while(left < right){
            while(left < right && array[right] >= temp){
                right--;
            }
            if(left < right){
                array[left++] = array[right];
            }

            while(left < right && array[left] <= temp){
                left++;
            }
            if(left < right){
                array[right--] = array[left];
            }
        }

        array[left] = temp;

        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);
    }

    // 堆排序
    public static void heapSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }

        int len = array.length;

        // 构建大顶堆
        buildMaxHeap(array, len);

        // 循环交换堆顶元素和末端元素，调整大顶堆
        for(int i = len - 1; i > 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // 调整大顶堆
            len--;
            heapify(array, 0, len);
        }
    }

    // 构建大顶堆
    public static void buildMaxHeap(int[] array, int len){
        // 从第一个非叶子结点向前构建
        for(int i = (len >> 1) - 1; i >= 0; i--){
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

        if(i != maxIndex){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            heapify(array, maxIndex, len);
        }
    }

    // 归并排序
    public static void mergeSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int mid = ((right - left) >> 1) + left;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    // 合并
    public static void merge(int[] array, int left, int mid, int right){
        if(left >= right){
            return;
        }

        int[] temp = new int[right - left + 1];

        int left1 = left;
        int left2 = mid + 1;
        int index = 0;

        while(left1 <= mid && left2 <= right){
            temp[index++] = array[left1] < array[left2] ? array[left1++] : array[left2++];
        }

        while(left1 <= mid){
            temp[index++] = array[left1++];
        }

        while(left2 <= right){
            temp[index++] = array[left2++];
        }

        for(int i = 0; i < temp.length; i++){
            array[left + i] = temp[i];
        }
    }
}