package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B5972 {

    static class Node implements Comparable<Node>{

        public int n,v;

        public Node(int n,int v){
            this.n=n;
            this.v=v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v-o.v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }

        int[] dis = new int[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1]=0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(int[] next:graph.get(cur.n)){
                if(dis[next[0]] > next[1]+cur.v){
                    dis[next[0]] = next[1]+cur.v;
                    pq.offer(new Node(next[0],dis[next[0]]));
                }
            }
        }

        System.out.println(dis[n]);
    }
}
