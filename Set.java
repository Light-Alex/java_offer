import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * HashSet: HashSet<Integer> hashSet = new HashSet<Integer>();
 * hashSet.add(Integer i);
 * 
 */
public class Set {
    public static void main(String[] args) {
        // 集合, HashSet(无序的)
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(2); // 添加一个元素
        hashSet.add(4); // 添加一个元素
        hashSet.add(7); // 添加一个元素
        hashSet.add(5); // 添加一个元素
        hashSet.add(1); // 添加一个元素
        hashSet.add(-1); // 添加一个元素
        hashSet.add(-3); // 添加一个元素
        System.out.println(hashSet); // 打印集合
        System.out.println(hashSet.size()); // 集合大小

        // hashSet.remove(1); // 移除一个元素
        System.out.println(hashSet.contains(2)); // 是否包含一个元素
        System.out.println(hashSet.isEmpty()); // 集合是否为空
        // hashSet.clear(); // 清空集合
        // hashSet.toArray(); // 集合转成数组

        // 遍历hashSet
        for(int i : hashSet){
            System.out.print(i + " ");
        }
        System.out.println();

        // 集合, TreeSet(有序的)(字典排序)
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(3); // 添加一个元素
        treeSet.add(-1);
        treeSet.add(-3);
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(7);
        treeSet.add(6);
        System.out.println(treeSet); // 打印集合
        System.out.println(treeSet.size()); // 集合大小

        // treeSet.remove(3); // 移除一个元素
        System.out.println(treeSet.contains(3)); // 是否包含一个元素
        System.out.println(treeSet.isEmpty()); // 集合是否为空
        // treeSet.clear(); // 清空集合
        // treeSet.toArray(); // 集合转成数组

        // 遍历treeSet
        for(int i : treeSet){
            System.out.print(i + " ");
        }
        System.out.println();

        // 列表, ArrayList(有序的，添加元素顺序)
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1); //第一个，索引下标0
        list.add(3); //第二个，索引下标1
        list.add(3); //第三个，索引下标2
        list.add(-1); //第四个，索引下标3
        list.add(-4); // [1, 3, 3, -1, -4], 允许使用重复元素
        System.out.println(list); // 打印集合
        System.out.println(list.get(2)); // 允许通过索引获取指定位置的元素

        list.add(1, 2); // 在指定位置添加元素
        System.out.println(list); // 打印集合

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(5);
        list1.add(6);
        list.addAll(list1); // 在list中添加一个list1列表
        System.out.println(list);

        System.out.println(list.indexOf(3)); // 获取指定元素在集合中第一次出现的索引下标
        System.out.println(list.lastIndexOf(3)); // 获取指定元素在集合中最后一次出现的索引下标

        // list.remove(3); // 根据索引移除元素
        // list.toArray(); // 将列表转成数组

        list.set(1, 55); // 根据索引下标修改元素
        // list.clear(); // 清空列表
        List<Integer> list3 = list.subList(2, 4); // 截取一段列表付给新列表, [开始索引, 结束索引)
        System.out.println(list3);
        System.out.println(list.size()); // 列表的长度

        // 遍历list
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();

        // 字典, HashMap, 无序的
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("b", 1); // 添加数据
        hashMap.put("c", 2);
        hashMap.put("e", 2);
        hashMap.put("b", 113); // 修改指定key的值
        System.out.println(hashMap); // {b=1, c=2, e=2}，打印字典

        System.out.println(hashMap.get("b")); // 1，根据key取值

        // hashMap.remove(b); // 根据key移除键值对
        // hashMap.clear(); // 清空字典
        System.out.println(hashMap.size()); // 字典长度
        System.out.println(hashMap.containsKey("b")); // 判断hashMap是否包含指定的key
        System.out.println(hashMap.containsValue(1)); // 判断hashMap是否包含指定的value

        // 遍历集合
        System.out.println(hashMap.keySet()); // 获取字典的所有key值
        System.out.println(hashMap.values()); // 获取字典的所有value值
        for(String s : hashMap.keySet()){
            System.out.println("key: " + s + ", " + "value: " + hashMap.get(s));
        }

        // 字典，TreeMap，有序的, 字典排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(3, 5);
        treeMap.put(1, 6);
        treeMap.put(-2, 7);
        treeMap.put(5, 1);
        System.out.println(treeMap); // {-2=7, 1=6, 3=5, 5=1}，字典排序
    }
}