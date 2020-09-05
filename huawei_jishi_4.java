import java.util.Scanner;

/**
 * 题目：字符串分隔
 * 
 * 题目描述：
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
   •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

   输入描述：
   连续输入字符串(输入2次,每个字符串长度小于100)

   输出描述：
   输出到长度为8的新字符串数组

   示例1:
   输入：
   abc
   123456789

   输出：
   abc00000
   12345678
   90000000
 */

public class huawei_jishi_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int index = 0; index < 2; index++){
            String s = sc.nextLine();
            int len = s.length() ;
            System.out.println(len);
            int num = len / 8;
            System.out.println(num);
            for(int i = 0; i < num; i++){
                System.out.println(s.substring(i * 8, (i + 1) * 8));
            }
            if(len == 8 * num){
                continue;
            }
            int extra = (num + 1) * 8 - len;
            String result = s.substring(num * 8);
            for(int i = 0; i < extra; i++){
                result += "0";
            }
            System.out.println(result);
        }

    }
}