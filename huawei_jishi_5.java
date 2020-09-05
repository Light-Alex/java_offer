import java.util.Scanner;

/**
 * 题目：进制转换
 * 
 * 题目描述：
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * 
 * 输出描述：
 * 输出该数值的十进制字符串。
 * 
 * 示例1：
 * 输入：
 * 0xA
 * 
 * 输出：
 * 10
 */

public class huawei_jishi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            s = s.substring(2);
            int result = 0;
            char[] charArray = s.toCharArray();
            int len = charArray.length;
            for(char c : charArray){
                if(c >= 'A' && c <= 'F'){
                    result += Math.pow(16, --len) * (c - 'A' + 10);
                }else{
                    result += Math.pow(16, --len) * (c - '0');
                }
            }
            System.out.println(result);
        }
    }
}