package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987 {

    static int n, ans;
    static int[] s, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        s = new int[n];
        w = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int idx) {
        if (idx == n) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (s[i] <= 0) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        if (s[idx] <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < n; i++) {
            if (idx == i || s[i] <= 0)
                continue;
            hit = true;
            s[idx] -= w[i];
            s[i] -= w[idx];
            dfs(idx + 1);
            s[idx] += w[i];
            s[i] += w[idx];
        }

        if(!hit){
            dfs(idx+1);
        }
    }
}
