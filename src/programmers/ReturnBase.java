package programmers;
import java.util.*;

public class ReturnBase {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road:roads){
            graph.get(road[0]).add(new int[]{road[1],0});
            graph.get(road[1]).add(new int[]{road[0],0});
        }

        PriorityQueue<int []> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.offer(new int[]{destination,0});
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[destination] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1]>dis[cur[0]])
                continue;
            for(int [] next : graph.get(cur[0])){
                if(dis[next[0]]>cur[1]+1){
                    dis[next[0]] = cur[1]+1;
                    q.offer(new int[]{next[0],dis[next[0]]});
                }
            }
        }

        int[] answer = new int[sources.length];
        int idx = 0;
        for(int x:sources){
            answer[idx++] = dis[x] == Integer.MAX_VALUE ? -1 : dis[x] ;
        }

        return answer;
    }
}
