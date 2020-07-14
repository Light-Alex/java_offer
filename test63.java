/**
 * 题目：删除链表中重复的结点
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/**
 * 方法：
 * 创建一个头结点，来处理第一个结点是重复结点的情况
 * 1、创建两个指针pre、last
 * 2、pre指针指向重复结点前一个结点
 * 3、last指针指向pre指针指向的结点的后一个结点用于寻找重复结点
 */

public class test63 {
    public static void main(String[] args) {
        
    }

    class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null){
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = pHead;
        ListNode pre = root;
        ListNode last = pre.next;

        while(last != null && last.next != null){
            if(last.val == last.next.val){
                while(last.next != null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
            }else{
                pre = pre.next;
            }

            last = pre.next;
        }

        return root.next;
    }
}