package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1577 {

    static int n, m, k;
    static boolean[][] blockedRight, blockedUp;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        blockedRight = new boolean[n + 1][m + 1];
        blockedUp = new boolean[n + 1][m + 1];
        dp = new long[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2) {
                int minY = Math.min(y1, y2);
                blockedUp[x1][minY + 1] = true;
            } else {
                int minX = Math.min(x1, x2);
                blockedRight[minX + 1][y1] = true;
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 &&!blockedRight[i][j]){
                    dp[i][j]+=dp[i-1][j];
                }

                if(j>0 && !blockedUp[i][j]){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
