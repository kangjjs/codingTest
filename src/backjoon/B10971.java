package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971 {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 1);
            visited[i] = false;
        }

        System.out.println(min);
    }

    static void dfs(int start, int now, int v, int l) {
        if (l == n) {
            if (map[now][start] != 0) {
                min = Math.min(min, v + map[now][start]);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, v + map[now][i], l + 1);
                visited[i] = false;
            }
        }
    }
}
