package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14716 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
