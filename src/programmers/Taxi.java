package programmers;

import java.util.*;

class Taxi {
    static class Way implements Comparable<Way> {
        int x, cost;

        public Way(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Way o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<ArrayList<int[]>> graph;

    public static int[] dijkstra(int start,int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

        PriorityQueue<Way> pq = new PriorityQueue<>();
        pq.offer(new Way(start,0));

        while(!pq.isEmpty()){
            Way cur = pq.poll();

            if(dist[cur.x] < cur.cost)
                continue;
            for(int[] next : graph.get(cur.x)){
                if(dist[next[0]]>cur.cost+next[1]){
                    dist[next[0]] = cur.cost+next[1];
                    pq.offer(new Way(next[0],cur.cost+next[1]));
                }
            }
        }

        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : fares) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
            graph.get(x[1]).add(new int[]{x[0], x[2]});
        }

        int[] together = dijkstra(s,n);
        int[] aloneA = dijkstra(a,n);
        int[] aloneB = dijkstra(b,n);

        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int tmp = together[i]+aloneA[i]+aloneB[i];
            if(answer>tmp)
                answer=tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Taxi s = new Taxi();
        System.out.println(s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(s.solution(7,3,4,1, new int[][]{{5,7,9}, {4,6,4}, {3,6,1}, {3,2,3}, {2,1,6}}));
    }
}