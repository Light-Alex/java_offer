import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目: 按字符出现频率排序字符串 题目描述：给定一个字符串，按字符出现频率的升序进行排序 如果两个字符的频率相同，按字符的字典顺序排序
 * 
 * 输入描述：一个字符串 输出描述：按频率升序排序后的字符串
 * 
 * 示例： 输入：cccbbaa 输出：aabbccc
 * 
 * 说明： 字符的频率：c-3, b-2, a-2 根据频率排序的字符: b-2, a-2, c-3 b和a字符的频率为2，字典顺序是先a后b
 * 所以最终输出是：aabbccc
 */
public class shopee_test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(stringSort(s));
        }
    }

    public static String stringSort(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        // 对HashMap排序
        Set<Map.Entry<Character, Integer>> entris = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(entris);

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });

        String result = "";
        for(int i = 0; i < list.size(); i++){
            int temp = list.get(i).getValue();
            TreeSet<Character> treeSet = new TreeSet<Character>();
            for(int j = i; j < list.size(); j++){
                if(list.get(j).getValue() == temp){
                    treeSet.add(list.get(j).getKey());
                }else{
                    i = j-1;
                    break;
                }
            }

            for(char c : treeSet){
                for(int x = 0; x < map.get(c); x++){
                    result += c;
                }
            }
        }

        return result;
    }
}