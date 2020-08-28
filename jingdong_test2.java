import java.util.Scanner;

/**
 * 题目：滚球游戏
 * 
 * 题目描述： 某滚球游戏规则如下：球从入口处（第一层）开始向下滚动，每次可向下滚动一层，直到滚至最下面一层为止。
 * 球每次可滚至左下、下方或右下三个方格中的任意一个，每个方格都有一个得分，如下图所示。
 * 第1层有1个方格，第2层有3个方格，……，以此类推，第n层有2*n-1个方格。 设计一个算法，使得球从入口滚至最下面一层的总得分和最大。
 * 
 * 输入描述： 第1行的正整数n表示数字三角形的层数。（n<=100)
 * 接下来n行包含一个数字三角形，每一行包含2*n-1个方格，对应有2*n-1个表示得分的正整数（不超过10^5）， 每两个数字之间用空格隔开。
 * 
 * 输出描述： 球从入口（第一层）滚至最下面一层的最大得分和。
 * 
 * 样例输入： 3 1 2 1 2 3 4 2 1 3
 * 
 * 样例输出： 7
 */

public class jingdong_test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a == 1){
            System.out.println(sc.nextInt());
            return;
        }
        int width = 2 * a - 1;
        int[][] array = new int[a][width];
        for(int i = 0; i < a; i++){
            int cur = 2 * (i + 1) - 1;
            for(int j = 0; j < cur; j++){
                array[i][(width - cur) / 2 + j] = sc.nextInt();
            }
        }
        int maxNum = 0;
        for(int i = 1; i < a; i++){
            int cur = 2 * (i + 1) - 1;
            for(int j = 0; j < cur; j++){
                int index = (width - cur) / 2 + j;
                if(index - 1 >= 0 && index + 1 <= width - 1){
                    array[i][index] = array[i][index] + maxNum(array[i-1][index-1], array[i-1][index], array[i-1][index+1]);
                }else if(index - 1 >= 0){
                    array[i][index] = array[i][index] + Math.max(array[i-1][index-1], array[i-1][index]);
                }else{
                    array[i][index] = array[i][index] + Math.max(array[i-1][index+1], array[i-1][index]);
                }
                if(array[i][index] > maxNum){
                    maxNum = array[i][index];
                }
            }
        }

        System.out.println(maxNum);        
    }

    public static int maxNum(int a, int b, int c){
        if(a > b){
            if(a > c){
                return a;
            }else{
                return c;
            }
        }else{
            if(a > c){
                return b;
            }else{
                if(b > c){
                    return b;
                }else{
                    return c;
                }
            }
        }
    }

    public static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}