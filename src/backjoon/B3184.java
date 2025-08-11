package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3184 {

    static int sheeps, wolves, r, c;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        sheeps = 0;
        wolves = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((map[i][j] == 'v' || map[i][j] == 'o') && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheeps + " " + wolves);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int wCnt = 0, oCnt = 0;

        if (map[x][y] == 'o')
            oCnt++;
        else if (map[x][y] == 'v')
            wCnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '#'
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                    if (map[nx][ny] == 'o')
                        oCnt++;
                    else if (map[nx][ny] == 'v')
                        wCnt++;
                }
            }
        }

        if (wCnt >= oCnt) {
            oCnt = 0;
        } else {
            wCnt = 0;
        }

        sheeps += oCnt;
        wolves += wCnt;
    }
}
