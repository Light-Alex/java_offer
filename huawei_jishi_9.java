import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 题目：提取不重复的整数
 * 
 * 题目描述：
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 
 * 输入描述：
 * 输入一个int型整数
 * 
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 
 * 示例1：
 * 输入：9876673
 * 输出：37689
 */

public class huawei_jishi_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = "" + a;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i = len - 1; i >= 0; i--){
            set.add(charArray[i]);
        }

        for(char c : set){
            System.out.print(c);
        }
    }
}