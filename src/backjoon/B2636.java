package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = 2;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int totalCheese = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    totalCheese++;
            }
        }

        int time = 0;
        int last = 0;

        while (totalCheese > 0) {
            last = totalCheese;
            bfs();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                        totalCheese--;
                    }
                }
            }

            time++;
        }

        System.out.println(time);
        System.out.println(last);
    }
}
