/**
 * 题目: 求1+2+3+...+n
 * 题目描述: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

// 方法: 使用短语与(&&)，再使用递归(n > 0) && (sum+=Sum_Solution(n-1) > 0), 当 n = 0 时，就不会往下递归了

public class test56 {
    public static void main(String[] args) {
        System.out.println(false);
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}