import java.util.LinkedHashMap;

/**
 * 题目：字符流中第一个不重复的字符
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 */

/**
 * 方法一：使用有序的字典: LinkedHashMap统计每个字符出现的次数，从前往后遍历LinkedHashMap输出只出现一次的字符(如果有的话)，没有则输出'#'
 */
public class test62_1 {
    LinkedHashMap<Character, Integer> dict = new LinkedHashMap<Character, Integer>();

    public static void main(String[] args) {
        
    }

    public void Insert(char ch){
        if(!dict.containsKey(ch)){
            dict.put(ch, 1);
        }else{
            dict.put(ch, dict.get(ch) + 1);
        }
    }

    public char FirstAppearingOnce(){
        for(char c : dict.keySet()){
            if(dict.get(c) == 1){
                return c;
            }
        }

        return '#';
    }
}