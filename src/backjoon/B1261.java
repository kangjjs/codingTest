package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1261 {

    static int n, m, ans;
    static char[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        dist = new int[m][n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.print(dist[m - 1][n - 1]);
    }

    static void bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        dist[0][0] = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (map[nx][ny] == '1' && dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    deque.addLast(new int[]{nx, ny});
                } else if (map[nx][ny] == '0' && dist[nx][ny] > dist[x][y]) {
                    dist[nx][ny] = dist[x][y];
                    deque.addFirst(new int[]{nx, ny});
                }
            }
        }
    }
}