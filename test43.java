import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：顺时针打印矩阵
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 
 * 1  2  3  4 
 * 5  6  7  8 
 * 9  10 11 12 
 * 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

/**
 * 方法一：
 * 每次打印完矩阵第一行后，逆时针旋转矩阵
 */

public class test43 {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        test43 t = new test43();
        System.out.println(t.printMatrix(array));
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<ArrayList<Integer>> matrixList = new ArrayList<ArrayList<Integer>>();
       
       // 将数组转成ArrayList
       for(int i = 0; i < matrix.length; i++){
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(int j = 0; j < matrix[0].length; j++){
                tempList.add(matrix[i][j]);
            }
            ArrayList<Integer> copyList = (ArrayList<Integer>) tempList.clone();
            matrixList.add(copyList);
            tempList.clear();
       }
       
       while(!matrixList.isEmpty()){
           ArrayList<Integer> copyList = (ArrayList<Integer>) matrixList.get(0).clone();
           result.addAll(copyList);
           matrixList.remove(0);
           matrixList = changeMatrix(matrixList);
       }

       return result;
    }

    // 逆时针旋转矩阵
    public ArrayList<ArrayList<Integer>> changeMatrix(ArrayList<ArrayList<Integer>> matrixList){
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> newMatrix = new ArrayList<ArrayList<Integer>>();

        if(matrixList.isEmpty()){
            return newMatrix;
        }

        for(int j = matrixList.get(0).size() - 1; j >= 0; j--){
            for(int i = 0; i < matrixList.size(); i++){
                tempList.add(matrixList.get(i).get(j));
            }

            ArrayList<Integer> copyList = (ArrayList<Integer>) tempList.clone();
            newMatrix.add(copyList);
            tempList.clear();
        }

        return newMatrix;
    }
}