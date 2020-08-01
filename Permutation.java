/**
 * 实现数组的全排列
 * {1, 2, 3}: {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 2, 1}, {3, 1, 2}
 * 
 * 方法：使用递归和回溯的思想，每次将数组中的一个数提到第一个位置，后面的元素做全排列即可，全排列后记得将数组还原
 */

public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Permutation p = new Permutation();
        p.permu(array, 0, array.length - 1);
    }

    /**
     * 对数组进行全排列
     * @param array 进行全排列的数组
     * @param left 全排列开始位置
     * @param right 全排列结束位置
     */
    public void permu(int[] array, int left, int right){
        // 只剩一个元素，就不用做全排列了
        if(left == right){
            printArray(array);
            return;
        }

        // 数组中每个元素提到前面，对剩余元素进行全排列
        for(int i = left; i < array.length; i++){
            // left是当前待全排列的数组的第一个元素下标
            swap(array, i, left);
            // 对剩余元素进行全排列
            permu(array, left + 1, right);
            // 数组还原
            swap(array, i, left);
        }
    }

    public void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}