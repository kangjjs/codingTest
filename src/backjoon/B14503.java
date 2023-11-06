package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {

    static int n, m, cnt = 1;
    static int[][] map;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void dfs(int x, int y, int dir) {

        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int newDir = (dir + 3) % 4;
            int nx = x + dx[newDir];
            int ny = y + dy[newDir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                cnt++;
                dfs(nx, ny, newDir);
                return;
            }

            dir=newDir;
        }

        int newDir = (dir + 2) % 4;
        int nx = x + dx[newDir];
        int ny = y + dy[newDir];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
            dfs(nx, ny, dir);
        }
    }


    public static void main(String[] args) throws IOException {
        B14503 T = new B14503();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int rDir = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.dfs(rx, ry, rDir);
        System.out.println(cnt);
    }
}
