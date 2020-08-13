import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：柱状图中最大的矩形
 * 
 * 题目描述：n 个柱子，求能勾勒出来的矩形的最大面积。
 */

/**
 * 方法二：单调栈求解
 * 遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度，就直接将当前柱体入栈，
 * 否则若当前的柱体高度小于栈顶柱体的高度，说明当前栈顶柱体找到了右边的第一个小于自身的柱体，
 * 那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了。
 */

public class leetcode_10_2 {
    public static void main(String[] args) {
        leetcode_10_2 ll = new leetcode_10_2();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(ll.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length); 
        
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                System.out.println("h:" +h);
                area = Math.max(area, (i - stack.peek() - 1) * h);   
            }
            stack.push(i);
            System.out.println("stack:" + stack);
        }

        return area;
    }
}