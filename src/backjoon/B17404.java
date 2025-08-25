package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404 {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = INF;

        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[n][3];

            for (int i = 0; i < 3; i++) {
                dp[0][i] = (i== start) ? cost[0][i] : INF;
            }

            for(int i=1;i<n;i++){
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + cost[i][2];
            }

            for (int last = 0; last < 3; last++) {
                if(start == last)
                    continue;
                answer = Math.min(answer,dp[n-1][last]);
            }
        }

        System.out.println(answer);
    }
}
