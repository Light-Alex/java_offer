import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：矩阵中的路径
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如：
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径,因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

/**
 * 方法：回溯法
 * 遍历矩阵中的每个位置
 */

public class test65 {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        test65 t = new test65();
        System.out.println(t.hasPath(matrix, 3, 4, "bcced".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix.length < 1 || matrix.length != rows * cols || rows < 1 || cols < 1){
            return false;
        }

        if(str.length < 1){
            return true;
        }

        char[][] newMatrix = new char[rows][cols];
        // 将一维数组 matrix转化为二维矩阵
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                newMatrix[i][j] = matrix[i * cols + j];
            }
        }

        // 从矩阵中的任意一个点出发寻找可能的路径
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // 若匹配到了某个路径则返回true
                if(search(newMatrix, i, j, str)){
                    return true;
                }
            }
        }

        // 没有相应路径返回false
        return false;
    }

    // 从(i, j)出发，递归遍历矩阵中的路径
    public boolean search(char[][] newMatrix, int i, int j, char[] str){
        if(newMatrix[i][j] == str[0]){
            // 走到尽头了，返回true
            if(str.length == 1){
                return true;
            }

            // 将经过的点置为空
            newMatrix[i][j] = ' ';

            // 尝试向左走一步，看一下是否与路径匹配
            if(j > 0 && search(newMatrix, i, j - 1, Arrays.copyOfRange(str, 1, str.length))){
                return true;
            }

            // 尝试向右走一步，看一下是否与路径匹配
            if(j < newMatrix[0].length - 1 && search(newMatrix, i, j + 1, Arrays.copyOfRange(str, 1, str.length))){
                return true;
            }

            // 尝试向上走一步，看一下是否与路径匹配
            if(i > 0 && search(newMatrix, i - 1, j, Arrays.copyOfRange(str, 1, str.length))){
                return true;
            }

            // 尝试向下走一步，看一下是否与路径匹配
            if(i < newMatrix.length - 1 && search(newMatrix, i + 1, j, Arrays.copyOfRange(str, 1, str.length))){
                return true;
            }

            // 四个方向都走不通，则将经过的点还原，并返回false
            newMatrix[i][j] = str[0];
            return false;
        }else{
            return false;
        }
    }
}