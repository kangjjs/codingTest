package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        int[][][] dp = new int[h][w][3];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], (int) 1e9);
            }
        }

        for (int j = 0; j < w; j++) {
            dp[0][j][0] = map[0][j];
            dp[0][j][1] = map[0][j];
            dp[0][j][2] = map[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                } else if (j == w - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                }
            }
        }

        int min = (int) 1e9;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(dp[h-1][i][j],min);
            }
        }

        System.out.println(min);
    }
}
