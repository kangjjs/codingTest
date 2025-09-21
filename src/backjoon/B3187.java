package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3187 {

    static int r, c, vCnt, kCnt;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        vCnt = 0;
        kCnt = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'v')
                    vCnt++;
                else if (map[i][j] == 'k')
                    kCnt++;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(kCnt + " " + vCnt);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int v = 0, k = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] != '#') {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'v')
                        v++;
                    else if (map[nx][ny] == 'k')
                        k++;
                }
            }
        }

        if (k > v) {
            vCnt -= v;
        } else {
            kCnt -= k;
        }
    }
}