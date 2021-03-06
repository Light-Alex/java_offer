/**
 * 题目：克隆图
 * 
 * 题目描述：
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
   图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 方法一：广度优先（使用队列），使用一个lookup字典来存放看过的值(原结点，复制结点)
 */

public class leetcode_8 {
    public static void main(String[] args) {
        
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val);
        lookup.put(node, clone);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            for(Node n : temp.neighbors){
                if(!lookup.containsKey(n)){
                    lookup.put(n, new Node(n.val));
                    queue.add(n);
                }

                lookup.get(temp).neighbors.add(lookup.get(n));
            }

        }

        return clone;
    }
}