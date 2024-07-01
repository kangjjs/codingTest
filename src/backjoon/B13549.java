package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549 {

    static class Node{
        int x,time;

        public Node(int x,int time){
            this.x=x;
            this.time=time;
        }
    }

    static boolean[] visited;
    static int n,m;
    static int ans = Integer.MAX_VALUE;
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            visited[cur.x] = true;
            if(cur.x==m)
                ans = Math.min(ans,cur.time);
            if(cur.x * 2<= 100000 && !visited[cur.x*2])
                q.offer(new Node(cur.x *2,cur.time));
            if(cur.x+1 <=100000 && !visited[cur.x+1])
                q.add(new Node(cur.x+1, cur.time+1));
            if(cur.x-1>=0&&!visited[cur.x-1])
                q.add(new Node(cur.x-1,cur.time+1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited= new boolean[200001];
        bfs();
        System.out.println(ans);
    }
}
