/**
 * 题目：合并两个排序的链表
 * 
 * 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */

/**
 * 方法：
 * 定义4个指针
   一个指针指向合并后的头结点
   一个指针指向当前结点
   一个指针指向list1链表中需要比较的结点
   一个指针指向list2链表中需要比较的结点
 */

public class test14 {
    public static void main(String[] args) {
        
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        
        if(list2 == null){
            return list1;
        }
        
        ListNode headPointer = list1.val < list2.val ? list1 : list2;
        ListNode currentPointer = headPointer;
        ListNode list1Pointer = list1;
        ListNode list2Pointer = list2;
        
        if(headPointer == list1){
            currentPointer = list1;
            list1Pointer = list1Pointer.next;
        }else{
            currentPointer = list2;
            list2Pointer = list2Pointer.next;
        }
        
        while(list1Pointer != null && list2Pointer != null){
            if(list1Pointer.val < list2Pointer.val){
                currentPointer.next = list1Pointer;
                currentPointer = list1Pointer;
                list1Pointer = list1Pointer.next;
            }else{
                currentPointer.next = list2Pointer;
                currentPointer = list2Pointer;
                list2Pointer = list2Pointer.next;
            }
        }
        
        if(list1Pointer == null){
            currentPointer.next = list2Pointer;
        }else{
            currentPointer.next = list1Pointer;
        }
        
        return headPointer;
    }
}