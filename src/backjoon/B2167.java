package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + x;
            }
        }
        StringBuilder sb= new StringBuilder();
        int x = Integer.parseInt(br.readLine());
        while(x-->0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(board[x2][y2]-board[x1-1][y2]-board[x2][y1-1]+board[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);
    }
}
