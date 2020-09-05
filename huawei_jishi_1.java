import java.util.Scanner;

/**
 * 题目：字符串最后一个单词的长度
 * 
 * 题目描述：
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 
 * 输入描述：
 * 一行字符串，非空，长度小于5000。
 * 
 * 输出描述：
 * 整数N，最后一个单词的长度。
 * 
 * 示例1：
 * 输入：
 * hello world
 * 
 * 输出：
 * 5
 */

public class huawei_jishi_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if(s.length() < 1 || s == null){
            System.out.println(0);
        }

        String[] sArray = s.split(" ");
        if(sArray.length == 0){
            System.out.println(0);
        }else{
            System.out.println(sArray[sArray.length - 1].length());
        }
    }
}