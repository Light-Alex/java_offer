import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 题目：字典排序
 */
public class nonghang_test1 {
    public static void main(String[] args) {
        System.out.println("PriorityQueue");
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("c");
        pq.add("a");
        pq.add("b");
        System.out.println(pq);

        System.out.println("TreeSet：");
        TreeSet<String> set = new TreeSet<>();
        set.add("c");
        set.add("a");
        set.add("b");
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("Cc");
        set.add("CC");
        set.add("BB");
        set.add("Bb");
        set.add("AA");
        set.add("Aa");
        System.out.println(set);

        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("b");
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("Cc");
        list.add("CC");
        list.add("BB");
        list.add("Bb");
        list.add("AA");
        list.add("Aa");
        System.out.println("排序前：");
        System.out.println(list);
        sortList(list);
        System.out.println("排序后：");
        System.out.println(list);
    }

    public static void sortList(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                char[] c1 = o1.toCharArray();
                char[] c2 = o2.toCharArray();

                int len1 = c1.length;
                int len2 = c2.length;
                int i = 0;
                while(i != len1 && i != len2){
                    if(c1[i] > c2[i]){ // 字符串o1的对应位的ascll码比字符串o2的大，o1就排在后面，后面的位就不用比了
                        return 1;
                    }else if(c1[i] < c2[i]){
                        return -1;
                    }else{
                        i++;
                    }
                }

                if(i == len1){ // 字符串o1到头了，o2可能还有剩余，则o2排在后面
                    return -1;
                }

                if(i == len2){
                    return 1;
                }

                return 0;
            }
            
        });
    }
}