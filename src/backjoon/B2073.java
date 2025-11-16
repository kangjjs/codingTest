package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] l = new int[p + 1];
        int[] c = new int[p + 1];

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[d + 1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= p; i++) {
            for (int j = d; j >= l[i]; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - l[i]], c[i]));
            }
        }

        System.out.println(dp[d]);
    }
}
