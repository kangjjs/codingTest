package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int[][] board = new int[2][m];
            int[][] dp = new int[2][m];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(m==1){
                sb.append(Math.max(board[0][0],board[1][0])).append('\n');
                continue;
            }

            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];
            dp[0][1] = Math.max(dp[0][0], board[0][1] + board[1][0]);
            dp[1][1] = Math.max(dp[1][0], board[0][0] + board[1][1]);
            for (int j = 2; j < m; j++) {
                dp[0][j] = Math.max(dp[1][j - 1] + board[0][j], Math.max(dp[1][j - 2] + board[0][j], dp[0][j - 1]));
                dp[1][j] = Math.max(dp[0][j - 1] + board[1][j], Math.max(dp[0][j - 2] + board[1][j], dp[1][j - 1]));
            }

            sb.append(Math.max(dp[0][m-1],dp[1][m-1])).append('\n');
        }

        System.out.print(sb);
    }
}
