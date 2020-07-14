/**
 * 题目：二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 1 2 3 4
 * 2 5 6 7
 * 3 6 8 10
 * 4 7 9 11
 */

/**
 * 观察右上角的元素可以发现：右上角的元素是这一行中最大的，是这一列中最小的，所以可以和右上角的元素进行比较：
 * if target > 4: i++: 在下一行查找
 * if target < 4: j--: 在这一行的左侧查找
 */

public class test4_2 {
    public static void main(String[] args) {
        int array[][] = {{1, 2, 3, 4}, {2, 5, 6, 7}, {3, 6, 8, 10}, {4, 7, 9, 11}};
        test4_2 t = new test4_2();
        System.out.println(t.Find(7, array));
    }

    public boolean Find(int target, int [][] array) {
        // 右上角元素的下标
        int i = 0;
        int j = array[0].length - 1;

        while(i < array.length && j >= 0){
            if(target < array[i][j]){
                j--;
            }else if(target > array[i][j]){
                i++;
            }else{
                return true;
            }
        }

        return false;
    }
}