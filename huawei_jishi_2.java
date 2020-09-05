import java.util.Scanner;

/**
 * 题目：计算字符个数
 * 
 * 题目描述：
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
 * 然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。
 * 
 * 示例1：
 * 输入：
 * ABCDEF
   A

   输出：
   1
 */

public class huawei_jishi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        String s = sc.nextLine();
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        
        char cc = sc.next().toLowerCase().charAt(0);
        for(char c : charArray){
            if(c == cc){
                num++;
            }
        }
        
        System.out.println(num);
    }
}