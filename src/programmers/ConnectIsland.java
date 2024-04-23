package programmers;

import java.util.*;

public class ConnectIsland {
    static class Node implements Comparable<Node>{
        int pos,cost;

        public Node(int pos,int cost){
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return this.cost - n.cost;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] x : costs){
            graph.get(x[0]).add(new Node(x[1],x[2]));
            graph.get(x[1]).add(new Node(x[0],x[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0));
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.pos])
                continue;
            visited[cur.pos] = true;
            answer += cur.cost;
            for(Node next : graph.get(cur.pos)){
                if(visited[next.pos])
                    continue;
                pq.offer(new Node(next.pos,next.cost));
            }
        }

        return answer;
    }
}
