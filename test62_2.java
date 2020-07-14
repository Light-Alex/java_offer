import java.util.ArrayList;

/**
 * 题目：字符流中第一个不重复的字符
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 */

/**
 * 方法二：使用两个ArrayList：list1, list2实现, list1用来存所有的字符, 再往list2添加元素时，首先判断该元素在list1中是否存在，存在就不添加, 同时移除在自己内部的该元素(如果存在的话), 若该元素在list1中不存在，则添加到list2中
 * 这样，list2中的第一个元素就是字符流中出现的第一个不重复的字符, 若list2为空，则输出'#'
 */
public class test62_2 {
    ArrayList<Character> list1 = new ArrayList<Character>();
    ArrayList<Character> list2 = new ArrayList<Character>();

    public static void main(String[] args) {
        char[] charArray = "google".toCharArray();
        test62_2 t = new test62_2();
        for(char c : charArray){
            t.Insert(c);
            System.out.println(t.FirstAppearingOnce());
        }
    }

    public void Insert(char ch){
        if(!list1.contains(ch)){
            list2.add(ch);
        }else{
            if(list2.contains(ch)){
                list2.remove(list2.indexOf(ch));
            }
        }

        list1.add(ch);
    }

    public char FirstAppearingOnce(){
        return list2.isEmpty() ? '#' : list2.get(0);
    }
}