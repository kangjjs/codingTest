package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {

    static int n;
    static int[] sour, bitter;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ans = Long.MAX_VALUE;
        sour = new int[n];
        bitter = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(Math.abs(bitter[0] - sour[0]));
            return;
        }

        dfs(0, 1L, 0L, false);

        System.out.println(ans);
    }

    static void dfs(int l, long s, long b, boolean used) {
        if (l == n) {
            if (used) {
                ans = Math.min(ans, Math.abs(b - s));
            }
            return;
        }

        dfs(l + 1, s * sour[l], b + bitter[l], true);
        dfs(l + 1, s, b, used);
    }
}
