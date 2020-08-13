/**
 * 题目：最大矩形
 * 
 * 题目描述：
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例：
 * 输入:
    [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
    ]
    输出: 6
 */

/**
 * 方法二：算出直方图，然后求出直方图能构成的最大面积
 */

public class leetcode_9_2 {
    public static void main(String[] args) {
        leetcode_9_2 ll = new leetcode_9_2();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        
        ll.printRectangle(matrix);
        System.out.println("=====================");
        System.out.println(ll.maximalRectangle(matrix));
    }

    public void printRectangle(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printRectangle(char[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printRectangle(int[] heights){
        for(int i = 0; i < heights.length; i++){
            System.out.print(heights[i]+ " ");
        }
        System.out.println();
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix.length == 0) {
            return maxArea;
        }
        
        int h = matrix.length;
        int w = matrix[0].length;
        // 求每一层的直方图，将结果带入 largestRectangleArea 获取当前层所能组成的最大面积
        int[] heights = new int[w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            // printRectangle(heights);
            // System.out.println("===========");
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }

    // 求直方图所能构成的最大面积
    public int largestRectangleArea(int[] heights){
        int area = 0;
        if(heights.length < 1){
            return area;
        }

        int len = heights.length;

        for(int i = 0; i < len; i++){
            int height = heights[i];
            int width = 1;
            int j = i;

            while(--j >= 0 && heights[j] >= height){
                width++;
            }

            j = i;

            while(++j < len && heights[j] >= height){
                width++;
            }

            area = Math.max(area, height * width);
        }

        return area;
    }
}