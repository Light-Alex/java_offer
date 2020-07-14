import java.util.Arrays;

public class Sort_test {
    public static void main(String[] args) {
        int[] array = {-1, -2, 0, 1, 2, 3, 1};

        System.out.println("冒泡排序：");
        int[] arr = Arrays.copyOf(array, array.length);
        Sort_test.bubbleSort(arr);
        Sort_test.printArray(arr);

        System.out.println("===================");
        System.out.println("选择排序：");
        arr = Arrays.copyOf(array, array.length);
        Sort_test.selectionSort(arr);
        Sort_test.printArray(arr);

        System.out.println("===================");
        System.out.println("插入排序：");
        arr = Arrays.copyOf(array, array.length);
        Sort_test.insertSort(arr);
        Sort_test.printArray(arr);

        System.out.println("===================");
        System.out.println("快速排序：");
        arr = Arrays.copyOf(array, array.length);
        Sort_test.quickSort(arr, 0, arr.length - 1);
        Sort_test.printArray(arr);

        System.out.println("===================");
        System.out.println("堆排序：");
        arr = Arrays.copyOf(array, array.length);
        Sort_test.heapSort(arr);
        Sort_test.printArray(arr);

        System.out.println("===================");
        System.out.println("归并排序：");
        arr = Arrays.copyOf(array, array.length);
        Sort_test.mergeSort(arr, 0, arr.length - 1);
        Sort_test.printArray(arr);
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 冒泡排序
    public static void bubbleSort(int array[]){
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
    public static void selectionSort(int array[]){
        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // 插入排序
    public static void insertSort(int array[]){
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                int temp = array[i];
                for(int j = i; j >= 0; j--){
                    if(j > 0 && array[j-1] > temp){
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
        int temp = array[left];

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

        // 交换末端元素和堆顶元素，然后调整最大堆
        for(int i = len - 1; i > 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            len--;
            heapify(array, 0, len);
        }
    }

    // 构建最大堆
    public static void buildMaxHeap(int[] array, int len){
        // 从最后一个非叶节点开始往前构建
        for(int i = (len >> 1) - 1; i >= 0; i--){
            heapify(array, i, len);
        }
    }

    // 调整最大堆
    public static void heapify(int[] array, int i, int len){
        // 左孩子索引
        int left = 2 * i + 1;
        // 右孩子索引
        int right = 2 * i + 2;
        // 保存最大值索引，假设父结点是最大值
        int maxIndex = i;

        // 如果左孩子存在
        if(left < len && array[left] > array[maxIndex]){
            maxIndex = left;
        }

        // 如果右孩子存在
        if(right < len && array[right] > array[maxIndex]){
            maxIndex = right;
        }

        // 如果最大值索引与父结点不一致，则进行交换
        if(i != maxIndex){
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            // 子结点发生变化，如果子结点还有子结点，则需要进行调整
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

        // 合并
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        if(left >= right){
            return;
        }

        // 用来存放合并后的数组
        int temp[] = new int[right - left + 1];

        int left1 = left;
        int left2 = mid + 1;
        int index = 0;

        while(left1 <= mid && left2 <= right){
            temp[index++] = array[left1] < array[left2] ? array[left1++] : array[left2++];
        }

        // 将剩余的元素加入到temp数组中
        while(left1 <= mid){
            temp[index++] = array[left1++];
        }

        while(left2 <= right){
            temp[index++] = array[left2++];
        }

        // 将temp数组复制到array数组
        for(index = 0; index < temp.length; index++){
            array[left + index] = temp[index];
        }
    }
}