package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot {
    int x, y, dir, count;

    public Robot(int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}

public class B1726 {

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static Robot start;
    static Robot finish;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public void bfs() {
        Queue<Robot> q = new LinkedList<>();
        visited[start.x][start.y][start.dir] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            Robot r = q.poll();
            int x = r.x;
            int y = r.y;
            int dir = r.dir;
            int count = r.count;

            if (x == finish.x && y == finish.y && dir == finish.dir) {
                System.out.println(count);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                int nx = x + (dx[dir - 1] * i);
                int ny = y + (dy[dir - 1] * i);

                if (nx <= 0 || nx > m || ny <= 0 || ny > n)
                    continue;
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][dir]) {
                        visited[nx][ny][dir] = true;
                        q.offer(new Robot(nx, ny, dir, count + 1));
                    }
                } else {
                    break;
                }
            }

            for (int i = 1; i <= 4; i++) {
                if (dir != i && !visited[x][y][i]) {
                    int turn = 1;

                    if ((dir == 1 && i == 2) || (dir == 2 && i == 1) || (dir == 3 && i == 4) || (dir == 4 && i == 3))
                        turn++;
                    visited[x][y][i] = true;
                    q.offer(new Robot(x, y, i, count + turn));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B1726 T = new B1726();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        visited = new boolean[m + 1][n + 1][5];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Robot(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0
        );

        st = new StringTokenizer(br.readLine());
        finish = new Robot(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0
        );
        T.bfs();
    }
}
