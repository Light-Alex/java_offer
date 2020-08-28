/**
 * 题目：第n个数
 * 
 * 题目描述：
 * 自从学了素数以后，小明喜欢上了数字2、3和5。当然，如果一个数字里面只出现2、3和5这三个数字，他也一样喜欢，例如222、2355、223355。
   现在他希望你能够帮他编写一个程序，快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5。

   输入描述：
   单组输入。
   每组输入数据占1行，每行输入一个正整数n。（n<=1000）

   输出描述：
   每组输出数据占1行，即满足要求的第n个数。

   样例输入：
   3
   样例输出：
   5
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class jingdong_test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a < 0){
            return;
        }

        if(a == 1){
            System.out.println("2");
            return;
        }
        if(a == 2){
            System.out.println("3");
            return;
        }
        if(a == 3){
            System.out.println("5");
            return;
        }
        
        String s = "";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("5");
        // int k = 0;

        LinkedList<String> list = new LinkedList<String>();
        list.add("2");
        list.add("3");
        list.add("5");
        a = a - 3;
        while(a >= 0){
            String temp = list.poll();
            for(int k = 0; k < 3; k++){
                list.add(temp + arrayList.get(k));
                a--;
                if(a == 0){
                    System.out.println(list.getLast());
                    return;
                }
            }
        }
    }
}