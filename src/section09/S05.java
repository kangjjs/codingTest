package section09;

import java.util.*;

class Edge implements Comparable<Edge>{

    public int v;
    public int c;

    public Edge(int v,int c){
        this.v=v;
        this.c=c;
    }

    @Override
    public int compareTo(Edge o) {
        return this.c-o.c;
    }
}
public class S05 {

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v){
        PriorityQueue<Edge> priorityQueue =new PriorityQueue<>();
        priorityQueue.offer(new Edge(v,0));
        dis[v]=0;

        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            int now = edge.v;
            int nowCost = edge.c;

            if(nowCost>dis[now])
                continue;
            for(Edge ob : graph.get(now)){
                if(dis[ob.v]>nowCost+ob.c){
                    dis[ob.v]=nowCost+ob.c;
                    priorityQueue.offer(new Edge(ob.v,nowCost+ob.c));
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

        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        for(int i=0;i<m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b,c));
        }

        T.solution(1);

        for(int i=2;i<=n;i++){
            if(dis[i]!=Integer.MAX_VALUE)
                System.out.println(i+" "+dis[i]);
            else
                System.out.println(i+" impossible");
        }
    }
}
