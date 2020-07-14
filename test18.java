/**
 * 题目：链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

/**
 * 方法：
 * 设置一个快慢指针fast和slow，快指针一次走两步，慢指针一次走一步，如果有环，则快慢指针一定会在环内相遇，相遇时，设慢指针走的路程为l，则快指针走的路程为2l
 * 设起点到环入口点的距离为s, slow在环内走的路程为d，快慢指针相遇处到环入口点的距离为m
 * 则可得：l = s + d, 2l = s + n * (m + d) + d，n = 1, 2, ...
 * 所以2(s + d) = s + n * (m + d) + d，即s = (n - 1)(m + d) + m，m + d为环长度的整数倍，(n - 1)(m + d)也为环长度的整数倍，加上(n - 1)(m + d)，环内位置不会改变，所以可以省略这部分，得s = m
 * 所以如果有环的话：两指针，一个从起点出发，一个从环内相遇处出发，同时同步走，相遇位置即为环的入口结点
 */
public class test18 {
    public static void main(String[] args) {
        
    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // 移动后再比是否相同，否则在起点处快慢指针会相同
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }
}