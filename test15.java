/**
 * 题目：复杂链表的复制
 * 
 * 题目描述：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

/*
方法：
1、在每个node后复制一个新的node，该node.lebal与上一个label相同
2、根据原node的random指向，确定新node的random指向：node.random.next
3、断开原node和新node之间的连接
*/
public class test15 {
    public static void main(String[] args) {
        
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
    
        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        
        RandomListNode temp1 = pHead;
        
        // 在原node后复制一个新node
        while(temp1 != null){
            RandomListNode tempNode = new RandomListNode(temp1.label);
            tempNode.next = temp1.next;
            temp1.next = tempNode;
            temp1 = tempNode.next;
        }
        
        RandomListNode newHead = pHead.next;
        temp1 = pHead;
        RandomListNode temp2 = newHead;
        
        // 根据原node的random指向确定新node的random指向
        while(temp1 != null){
            if(temp1.random != null){
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next;
        }
        
        // 断开原node和新node之间的连接
        temp1 = pHead;
        temp2 = newHead;
        while(temp1 != null){
            temp1.next = temp2.next;
            if(temp2.next != null){
                temp2.next = temp2.next.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}