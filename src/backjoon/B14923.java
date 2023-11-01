package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class WallPoint {
    public int x, y, count, broken;

    public WallPoint(int x, int y, int count, int broken) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.broken = broken;
    }
}

public class B14923 {

    static int n, m, hx, hy, ex, ey;
    static int[][] mirror;
    static int[][][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void bfs() {
        Queue<WallPoint> q = new LinkedList<>();
        q.offer(new WallPoint(hx, hy, 0, 0));
        visited[hx][hy][0] = 1;

        while (!q.isEmpty()) {
            WallPoint current = q.poll();

            if (current.x == ex && current.y == ey) {
                System.out.println(current.count);
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = current.x + dx[j];
                int ny = current.y + dy[j];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (mirror[nx][ny] == 0 && visited[nx][ny][current.broken] == 0) {
                        q.offer(new WallPoint(nx, ny, current.count + 1, current.broken));
                        visited[nx][ny][current.broken] = 1;
                    } else if (mirror[nx][ny] == 1 && current.broken == 0 && visited[nx][ny][1] == 0) {
                        q.offer(new WallPoint(nx, ny, current.count + 1, 1));
                        visited[nx][ny][1] = 1;
                    }
                }
            }
        }
        System.out.println("-1");
    }

        public static void main (String[]args) throws IOException {
            B14923 T = new B14923();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            mirror = new int[n + 1][m + 1];
            visited = new int[n + 1][m + 1][2];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    mirror[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            T.bfs();
        }
    }
