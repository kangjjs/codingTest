package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[0][s] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j] > 0) {
                    if (j + arr[i] <= m) {
                        dp[i + 1][j + arr[i]] = 1;
                    }

                    if (j - arr[i] >= 0) {
                        dp[i + 1][j - arr[i]] = 1;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i] == 1) {
                ans = Math.max(i, ans);
            }
        }

        System.out.println(ans);
    }
}
