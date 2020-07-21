import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap根据key或根据value进行排序
 */

public class HashMap_Sort {
    public static void main(String[] args) {

        // Double d1 = 2.0;
        // Double d2 = 0.0;
        // System.out.println(d1.compareTo(d2)); // -1, 0, 1

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();

        map.put(2.2, 1);
        map.put(3.0, 0);
        map.put(1.5, 2);
        map.put(0.0, 3);
        map.put(4.5, -1);

        // HashMap是无序的
        System.out.println(map); // {0.0=3, 4.5=-1, 3.0=0, 1.5=2, 2.2=1}

        // 获取HashMap的条目: Entry
        Set<Map.Entry<Double, Integer>> entrys = map.entrySet();
        // 打印每一个条目: Entry
        for (Map.Entry<Double, Integer> entry : entrys) {
            System.out.println("key:" + entry.getKey() + " " + "value:" + entry.getValue());
        }

        // 使用Collections对HashMap进行排序，因为Collections.sort()的参数类型是List类型，所以先使用一个ArrayList保存HashMap中的元素
        ArrayList<Map.Entry<Double, Integer>> list = new ArrayList<Map.Entry<Double, Integer>>();
        list.addAll(entrys); // 也可以通过构造函数的参数传入
        System.out.println(list); // [0.0=3, 4.5=-1, 3.0=0, 1.5=2, 2.2=1]

        // 排序, 调用Collections.sort(List<T> list, Comparator<? super T> c)方法, 注意：需要重写 Comparator<T>类 中的 compare()方法
        Collections.sort(list, new Comparator<Map.Entry<Double, Integer>>() {
            @Override
            public int compare(Entry<Double, Integer> o1, Entry<Double, Integer> o2) {
                // compareTo方法: A.compareTo(B)返回值
                // A > B: 1
                // A = B: 0
                // A < B: -1

                // 根据key升序排序
                // return o1.getKey().compareTo(o2.getKey());

                // 根据key降序排序
                // return o2.getKey().compareTo(o1.getKey());

                // 根据value升序排序
                // return o1.getValue().compareTo(o2.getValue());

                // 根据value降序排序
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // 原HashMap的顺序不会变化, 顺序变化的是list
        // 输出list
        System.out.println(list); // [0.0=3, 1.5=2, 2.2=1, 3.0=0, 4.5=-1]
        // 按照key value 的形式输出
        for(Map.Entry<Double, Integer> m : list){
            System.out.println("key:" + m.getKey() + " " + "value:" + m.getValue());
        }
        // key:0.0 value:3
        // key:1.5 value:2
        // key:2.2 value:1
        // key:3.0 value:0
        // key:4.5 value:-1
    }
}