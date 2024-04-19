package programmers;

import java.util.*;

class MaxNode {

    static class Node{
        int n,v;

        public Node(int n,int v){
            this.n=n;
            this.v=v;
        }
    }

    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        int max = 0;
        int answer = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (dist[cur.n] < cur.v)
                continue;
            if (max == cur.v)
                answer++;
            else if (max < cur.v) {
                max = cur.v;
                answer = 1;
            }
            for (int x : graph.get(cur.n)) {
                if (dist[x] > cur.v + 1) {
                    dist[x] = cur.v + 1;
                    q.offer(new Node(x, cur.v + 1));
                }
            }
        }

        return answer;
    }
}
