package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            System.out.println(getPaths(n, m));
        } else {
            int row = (k - 1) / m;
            int col = (k - 1) % m;

            int path1 = getPaths(row + 1, col + 1);
            int path2 = getPaths(n - row, m - col);

            System.out.println(path1 * path2);
        }
    }

    static int getPaths(int x, int y) {
        int[][] dp = new int[x][y];

        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < y; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[x - 1][y - 1];
    }
}
