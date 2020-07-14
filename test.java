public class test {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        System.out.println(test.binarySearch(a, 5));
        System.out.println(-3 % 2);
        System.out.println((Integer)null);
    }

    // 折半查找
    public static int binarySearch(int[] array, int value){
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) >> 1;
            if(array[mid] == value){
                return mid;
            }else if(array[mid] < value){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return 0;
    }
}