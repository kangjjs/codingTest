package section09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int v;
    public int c;

    public Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge o) {
        return this.c - o.c;
    }
}

public class S05 {

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int x) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(x, 0));
        dis[x] = 0;

        while (!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();
            int c = e.c;
            int v = e.v;

            if (c > dis[v])
                continue;

            for (Edge edge : graph.get(v)) {
                if (dis[edge.v] > c + edge.c) {
                    dis[edge.v] = c + edge.c;
                    priorityQueue.offer(new Edge(edge.v,c+edge.c));
                }
            }
        }
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        graph = new ArrayList<ArrayList<Edge>>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);


        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();

            graph.get(a).add(new Edge(b, c));
        }

        T.solution(1);

        for(int i=2;i<=n;i++){
            if(dis[i]!=Integer.MAX_VALUE)
                System.out.println(i+" : "+dis[i]);
            else
                System.out.println(i+" : impossible");
        }
    }
}
