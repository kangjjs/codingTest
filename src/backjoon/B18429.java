package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18429 {

    static int n, k, ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        System.out.println(ans);
    }

    static void dfs(int l, int w) {
        if (l == n) {
            ans++;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int next = w + arr[i] - k;
                    if (next >= 500) {
                        visited[i] = true;
                        dfs(l + 1, next);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
