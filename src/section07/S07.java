package section07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class S07 {
    Node root;

    public void solution(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.pop();
                System.out.print(node.data + " ");
                if(node.lt!=null)
                    queue.offer(node.lt);
                if(node.rt!=null)
                    queue.offer(node.rt);
            }
        }
    }

    public static void main(String[] args) {
        S07 tree = new S07();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.solution(tree.root);
    }
}

