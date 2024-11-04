package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 1});
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][1] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int crash = cur[2];
            int dist = cur[3];

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (map[nx][ny] == 0 && !visited[nx][ny][crash]) {
                    visited[nx][ny][crash] = true;
                    q.add(new int[]{nx, ny, crash, dist + 1});
                }

                if (map[nx][ny] == 1 && crash==1 && !visited[nx][ny][0]) {
                    visited[nx][ny][0] = true;
                    q.add(new int[]{nx, ny, 0, dist + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
