package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    static int n,m;
    static int answer;
    static int [][] check;
    static int [][] dist;

    static void bfs(int[][]maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        check[0][0] = 1;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0&&nx<n&&ny>=0&&ny<m&&maps[nx][ny]==1){
                    if(check[nx][ny]==0){
                        check[nx][ny]=1;
                        q.offer(new int[]{nx,ny});
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }

    public int solution(int[][] maps) {
        answer = 0;
        n = maps.length;
        m = maps[0].length;
        check = new int[n][m];
        dist = new int[n][m];
        dist[0][0] = 1;
        bfs(maps);

        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}
