package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i - a - 1 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - a - 1] + 1);
            }

            if (i - b - 1 >= 0)
                dp[i] = Math.min(dp[i], dp[i - b - 1] + 1);
        }

        System.out.println(dp[n]);
    }
}