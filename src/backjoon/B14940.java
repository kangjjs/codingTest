package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x=i;
                    y=j;
                }
            }
        }
        int[][] distance = map.clone();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        distance[x][y]=0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int d = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j]+cur[0];
                    int ny = dy[j]+cur[1];

                    if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]==1){
                        if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            distance[nx][ny]=d;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
            d++;
        }

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(distance[i][j]==1&&!visited[i][j]){
                    distance[i][j]=-1;
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        for (int[] dis:distance){
            for(int w:dis){
                sb.append(w).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
