package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] map;
    static boolean[] visited;
    static int ans;

    static void dfs(int l, int x, int y) {
        ans = Math.max(l, ans); // 최대 칸 수 갱신

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }

            if (!visited[map[nx][ny] - 'A']) {
                visited[map[nx][ny] - 'A'] = true;
                dfs(l + 1, nx, ny);
                visited[map[nx][ny] - 'A'] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        ans = 0;
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;
        dfs(1,0,0);

        System.out.println(ans);
    }
}
