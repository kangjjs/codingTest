package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x == y) {
            System.out.println(1);
            return;
        }

        long[][] dp = new long[31][31];
        dp[x][x] = 1;

        for (int i = x; i <= y; i++) {
            for (int j = x; j <= i; j++) {
                if (i > x)
                    dp[i][j] += dp[i - 1][j];
                if (j > x)
                    dp[i][j] += dp[i][j - 1];
            }
        }

        System.out.println(dp[y][y]);
    }
}