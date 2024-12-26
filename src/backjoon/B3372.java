package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class B3372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BigInteger[][] dp = new BigInteger[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], BigInteger.ZERO);
        dp[0][0] = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;

                int jump = map[i][j];

                if (j + jump < n) {
                    dp[i][j + jump] = dp[i][j + jump].add(dp[i][j]);
                }

                if (i + jump < n) {
                    dp[i + jump][j] = dp[i + jump][j].add(dp[i][j]);
                }
            }
        }

        System.out.print(dp[n - 1][n - 1]);
    }
}