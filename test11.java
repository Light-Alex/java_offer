/**
 * 题目：从尾到头打印链表
 * 
 * 题目描述：输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */

/**
 * 方法：队列的思想，使用ArrayList的add(int index, Object obj)方法在ArrayList头部添加元素
 */

import java.util.ArrayList;

public class test11 {
    public static void main(String[] args) {
        
    }

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(listNode != null){
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        
        return list;
    }
}