package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited, iceberg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0, cnt = 0;
        while (true) {
            if (melting()) {
                int c = findMap();
                if (c > 1) {
                    ans = cnt + 1;
                    break;
                }
            } else {
                break;
            }
            cnt++;
        }

        System.out.println(ans);
    }

    static boolean melting() {
        iceberg = new boolean[n][m];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    iceberg[i][j] = true;
                    map[i][j] -= melt(i, j);
                    if(map[i][j]<0)
                        map[i][j]=0;
                    flag = true;
                }
            }
        }

        return flag;
    }

    static int melt(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !iceberg[nx][ny]) {
                cnt++;
            }
        }

        return cnt;
    }

    static int findMap() {
        visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}