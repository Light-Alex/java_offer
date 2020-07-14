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

// 方法一：遍历，时间复杂度：O(n^2)

public class test4_1 {
    public static void main(String[] args) {
        int array[][] = {{1, 2, 3, 4}, {2, 5, 6, 7}, {3, 6, 8, 10}, {4, 7, 9, 11}};
        test4_1 t = new test4_1();
        System.out.println(t.Find(7, array));
    }

    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}