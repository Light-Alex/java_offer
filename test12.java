/**
 * 题目：链表中倒数第k个结点
 * 
 * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
 * 
 */

/**
 * 方法：定义一个快慢指针，两指针间隔为k, 两指针同步移动，当快指针到null时，慢指针指向的结点就是倒数第k个结点
   若 k>链表的长度 则返回null
 */

public class test12 {
    public static void main(String[] args) {
        
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        
        for(int i = 0; i < k; i++){
            if(secondPointer == null){
                return null;
            }
            
            secondPointer = secondPointer.next;
        }
        
        while(secondPointer != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        
        return firstPointer;
    }
}