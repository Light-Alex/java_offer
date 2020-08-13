/**
 * 题目：柱状图中最大的矩形
 * 
 * 题目描述：n 个柱子，求能勾勒出来的矩形的最大面积。
 */

/**
 * 方法一：暴力解法
 * 我们可以遍历每根柱子，以当前柱子 i 的高度作为矩形的高，
 * 那么矩形的宽度边界即为向左找到第一个高度小于当前柱体 i 的柱体，向右找到第一个高度小于当前柱体 i 的柱体。
   对于每个柱子我们都如上计算一遍以当前柱子作为高的矩形面积，最终比较出最大的矩形面积即可。
 */

public class leetcode_10_1 {
    public static void main(String[] args) {
        leetcode_10_1 ll = new leetcode_10_1();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(ll.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
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