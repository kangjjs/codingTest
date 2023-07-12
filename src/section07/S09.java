package section07;

import java.util.*;

public class S09 {
    Node root;

    public int solution(int n, Node root) {
        if (root.lt == null && root.rt == null)
            return n;
        else
            return Math.min(solution(n+1,root.lt), solution(n + 1, root.rt));
    }

    public static void main(String[] args) {
        S09 T = new S09();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        System.out.println(T.solution(0, T.root));
    }
}
