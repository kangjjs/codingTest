package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520 {

    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] dp, board;
    static int N, M;

    static int dfs(int x, int y) {
        if (x == N && y == M)
            return 1;
        if (dp[x][y] != -1)
            return dp[x][y];
        else {
            int current = board[x][y];
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=1&&nx<=N&&ny>=1&&ny<=M){
                    int next = board[nx][ny];

                    if(current>next){
                        dp[x][y]+=dfs(nx,ny);
                    }
                }
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));
    }
}
