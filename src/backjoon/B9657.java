package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[Math.max(n + 1, 5)];

        dp[0] = false;
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;

        for (int i = 5; i <= n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
