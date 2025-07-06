package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] map = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                sum[i][j] = map[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            int s = sum[nx][ny] - sum[dx - 1][ny] - sum[nx][dy - 1] + sum[dx - 1][dy - 1];
            int x = (nx - dx + 1) * (ny - dy + 1);
            sb.append(s / x).append('\n');
        }

        System.out.print(sb);
    }
}
