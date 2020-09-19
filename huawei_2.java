public class huawei_2 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        

    }

    public static void reverseList(Node root, int val1, int val2){
        
        Node first = root;
        // Node second = first.next;
        // Node third = second.next;

        Node temp1 = root;

        for(int i = 2; i < val1; i++){
            temp1 = temp1.next;
        }

        for(int i = 1; i < val1; i++){
            first = first.next;
        }

        Node temp2 = first;

        Node second = first.next;
        Node third = second.next;

        for(int i = 1; i < val2 - val1 + 1; i++){
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }

        temp1.next = first;

        temp2.next = second;
    }
}

class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}