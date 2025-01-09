package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1189 {

    static int r, c, k, ans;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited[r-1][0]=true;
        ans = 0;
        dfs(r-1, 0, 1);
        System.out.print(ans);
    }

    static void dfs(int x, int y, int l) {
        if(l>k)
            return;
        if (x == 0 && y == c - 1) {
            if (l == k)
                ans++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != 'T' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, l + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
