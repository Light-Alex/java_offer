/**
 * 题目：反转链表
 * 
 * 题目描述：输入一个链表，反转链表后，输出新链表的表头。
 */

/**
 * 方法：定义三个指针: firstPointer、secondPointer、thirdPointer
 */

public class test13 {
    public static void main(String[] args) {
        
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return head;
        }
        
        ListNode firstPointer = head;
        ListNode secondPointer = firstPointer.next;
        ListNode thirdPointer = secondPointer.next;
        
        firstPointer.next = null;
        
        while(thirdPointer != null){
            secondPointer.next = firstPointer;
            firstPointer = secondPointer;
            secondPointer = thirdPointer;
            thirdPointer = thirdPointer.next;
        }
        
        secondPointer.next = firstPointer;
        
        return secondPointer;
    }
}