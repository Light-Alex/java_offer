/**
 * 题目：整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
// 方法一：遍历
public class test22_1 {
    public static void main(String[] args) {
        int n = 13;
        test22_1 t = new test22_1();
        System.out.println(t.NumberOf1Between1AndN_Solution(n));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        char[] c;
        int count = 0;
        for(int i = 1; i <= n; i++){
            c = (i + "").toCharArray();
            for(char j : c){
                if(j == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}