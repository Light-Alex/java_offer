/**
 * 题目：两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

/**
 * 方法：
 * 分两种情况：两个链表的长度相同、两个链表的长度不相同
 * 定义两个指针分别指向两个链表的表头
 * 1、两个链表的长度相同：两个指针同时走，直到遇到公共结点
 * 2、找出两个指针的长度差k，让长的链表的指针先走k步，然后两个链表的指针同时走，直到遇到公共结点
 */
public class test16 {
    public static void main(String[] args) {
        
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        int k = 0;

        if(temp1 != null){
            while(temp1 != null){
                temp1 = temp1.next;
                k++;
            }

            temp1 = pHead1;
            temp2 = pHead2;

            for(int i = 0; i < k; i++){
                temp1 = temp1.next;
            }

            while(temp1 != null && temp2 != null){
                if(temp1 == temp2){
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }else{
            while(temp2 != null){
                temp2 = temp2.next;
                k++;
            }

            temp1 = pHead1;
            temp2 = pHead2;

            for(int i = 0; i < k; i++){
                temp2 = temp2.next;
            }

            while(temp1 != null && temp2 != null){
                if(temp1 == temp2){
                    return temp1;
                }

                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }
}