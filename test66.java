/**
 * 题目：机器人的运动范围
 * 题目描述：地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */

/**
 * 方法：创建一个行数为rows，列数为cols全是0的矩阵(0表示没有走过)
 * 矩阵上某个位置能够被访问的条件为:
 * 1、i, j在矩阵范围内，没有出现越界
 * 2、该位置没有被访问过(即该位置上的值为0)
 * 3、行坐标和列坐标位数之和 <= threshold
 * 某个位置被访问，则该位置上的值+1，表示该位置被访问过了
 * 从(0, 0)位置出发，定义一个全局变量count, 经过一个位置count++
 */

public class test66 {
    int count = 0;
    public static void main(String[] args) {
        
    }

    public int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows < 1 || cols < 1){
            return count;
        }

        int[][] matrix = new int[rows][cols];

        // 从(0, 0)位置开始搜索
        search(matrix, 0, 0, threshold);
        return count;
    }

    public void search(int[][] matrix, int i, int j, int threshold){
        // 能访问(i, j)这个位置的条件
        if(i >= 0 && i < matrix.length && j >=0 && j < matrix[0].length && matrix[i][j] == 0 && Sum(i, j) <= threshold){
            matrix[i][j]++;
            count++;

            // 向下走一步
            search(matrix, i+1, j, threshold);
            // 向上走一步
            search(matrix, i-1, j, threshold);
            // 向右走一步
            search(matrix, i, j+1, threshold);
            // 向左走一步
            search(matrix, i, j-1, threshold);
        }else{
            return;
        }
    }

    // 计算行数和列数的位数和
    public int Sum(int row, int col){
        int result = 0;
        while(row != 0){
            result += row % 10;
            row = row / 10;
        }

        while(col != 0){
            result += col % 10;
            col = col / 10;
        }
        return result;
    }
}