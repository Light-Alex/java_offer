import java.util.LinkedHashMap;

/**
 * 题目：第一个只出现一次的字符
 * 题目描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */

/**
 * 方法一：使用LinkedHashMap(有序字典)统计每个字符的数量，返回只出现一次的字符的下标(如果有的话)
 */
public class test46_1 {
    public static void main(String[] args) {
        
    }

    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() < 1){
            return -1;
        }
        
        LinkedHashMap<Character, Integer> dict = new LinkedHashMap<Character, Integer>();

        char[] charArray = str.toCharArray();

        for(char c : charArray){
            if(!dict.containsKey(c)){
                dict.put(c, 1);
            }else{
                dict.put(c, dict.get(c) + 1);
            }
        }

        for(char c : dict.keySet()){
            if(dict.get(c) == 1){
                return str.indexOf(c);
            }
        }

        return -1;
    }
}