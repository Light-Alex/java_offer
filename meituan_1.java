public class meituan_1{
    public static void main(String[] args) {
        meituan_1 m = new meituan_1();
        Node t1 = m.new Node(1);
        Node t2 = m.new Node(2);
        Node t3 = m.new Node(3);
        t1.next = t2;
        t2.next = t3;
        t3.next = null;

        Node head = m.reverseList(t1);

        m.printList(head);
    }

    class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }

    public void printList(Node node){
        if(node == null){
            return;
        }

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node reverseList(Node node){
        if(node == null){
            return null;
        }

        Node first = node;
        Node second = node.next;

        first.next = null;

        while(second != null) {
            Node temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        return first;
    }
}