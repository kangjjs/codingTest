package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485 {

    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int[][] map = new int[n + 1][n + 1];
            int[][] dist = new int[n + 1][n + 1];
            boolean[][] visited = new boolean[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(1,1,map[1][1]));
            dist[1][1] = map[1][1];
            visited[1][1] = true;
            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x+dx[i];
                    int ny = cur.y+dy[i];
                    if(nx>0&&nx<=n&&ny>0&&ny<=n&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        pq.offer(new Node(nx,ny,cur.dist+map[nx][ny]));
                        dist[nx][ny] = cur.dist+map[nx][ny];
                    }
                }
            }
            System.out.println("Problem "+(idx++)+": "+dist[n][n]);
        }
    }
}
