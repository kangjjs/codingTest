package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16938 {

    static int n, l, r, x, ans = 0;
    static int[] test;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        test = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, Integer.MAX_VALUE, -1);
        System.out.println(ans);
    }

    static void dfs(int length, int sum, int easy, int hard) {
        if (length == n) {
            if (sum >= l && sum <= r && (hard - easy) >= x)
                ans++;
            return;
        }

        dfs(length + 1, sum, easy, hard);
        dfs(length + 1, sum + test[length], Math.min(easy, test[length]), Math.max(hard, test[length]));
    }
}
