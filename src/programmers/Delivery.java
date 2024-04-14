package programmers;

import java.util.*;

class Delivery {

    static class Town implements Comparable<Town>{
        int x,cost;

        public Town(int x,int cost){
            this.x=x;
            this.cost=cost;
        }

        @Override
        public int compareTo(Town t){
            return this.cost-t.cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Town>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        int l = road.length;

        for(int i=0;i<l;i++){
            graph.get(road[i][0]).add(new Town(road[i][1],road[i][2]));
            graph.get(road[i][1]).add(new Town(road[i][0],road[i][2]));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=1;

        PriorityQueue<Town> pq =new PriorityQueue<>();
        pq.offer(new Town(1,0));

        while(!pq.isEmpty()){
            Town cur = pq.poll();
            if(cur.cost>dist[cur.x])
                continue;
            for(Town next:graph.get(cur.x)){
                if(dist[next.x]>next.cost+cur.cost){
                    dist[next.x] = next.cost + cur.cost;
                    pq.offer(new Town(next.x,dist[next.x]));
                }
            }
        }

        for(int i=1;i<dist.length;i++){
            if(dist[i]<=K)
                answer++;
        }

        return answer;
    }
}