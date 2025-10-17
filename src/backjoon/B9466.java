package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9466 {

    static int res;
    static int[] arr;
    static boolean[] visited, done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            done = new boolean[n + 1];
            visited = new boolean[n + 1];
            res = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (done[i])
                    continue;
                dfs(i);
            }

            sb.append(n - res).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int x) {
        if (done[x])
            return;
        if (visited[x]) {
            done[x] = true;
            res++;
        }

        visited[x] = true;
        dfs(arr[x]);
        done[x] = true;
        visited[x] = false;
    }

}
