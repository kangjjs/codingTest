package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        int num = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    divide(i, j, num++);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    ans = Math.min(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    static void divide(int i, int j, int l) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        map[i][j] = l;
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != 0) {
                    map[nx][ny] = l;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0});
        boolean[][] visit = new boolean[n][n];
        visit[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny, cur[2] + 1});
                    } else if(map[nx][ny] != map[i][j]){
                        return cur[2];
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
