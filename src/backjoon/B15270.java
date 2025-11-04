package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15270 {

    static int n, m, ans = 0;
    static boolean[][] friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = true;
            friends[b][a] = true;
        }
        visited = new boolean[n + 1];
        dfs(1,0);
        if(ans<n)
            ans++;
        System.out.println(ans);
    }

    static void dfs(int idx, int cnt) {
        if (idx > n) {
            ans = Math.max(ans, cnt * 2);
            return;
        }

        if (visited[idx]) {
            dfs(idx + 1, cnt);
            return;
        }

        visited[idx] = true;
        for (int i = idx + 1; i <= n; i++) {
            if (!visited[i] && friends[idx][i]) {
                visited[i] = true;
                dfs(idx + 1, cnt+1);
                visited[i] = false;
            }
        }

        visited[idx] = false;
        dfs(idx + 1, cnt);
    }
}
