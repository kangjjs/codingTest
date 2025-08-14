package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14442 {

    static int n, m, k;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        if (map[0][0] == '1') {
            if (k == 0)
                return -1;
            visited[0][0][1] = true;
            q.add(new int[]{0, 0, 1, 1});
        } else if (map[0][0] == '0') {
            visited[0][0][0] = true;
            q.add(new int[]{0, 0, 0, 1});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int b = cur[2];
            int dist = cur[3];

            if(x==n-1 && y==m-1){
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (map[nx][ny] == '0') {
                    if (!visited[nx][ny][b]) {
                        visited[nx][ny][b] = true;
                        q.offer(new int[]{nx, ny, b, dist + 1});
                    }
                } else {
                    if (b < k && !visited[nx][ny][b + 1]) {
                        visited[nx][ny][b+1] = true;
                        q.offer(new int[]{nx,ny,b+1,dist+1});
                    }
                }
            }
        }

        return -1;
    }
}
