package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17276 {

    static int mid, n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            mid = n / 2;

            if (d < 0)
                d += 360;
            d /= 45;

            for (int i = 0; i < d; i++) {
                rotate();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static void rotate() {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < n; i++) {
            map[i][n / 2] = copy[i][i];
            map[i][i] = copy[n / 2][i];
            map[n / 2][i] = copy[n - i - 1][i];
            map[n - i - 1][i] = copy[n - i - 1][n / 2];
        }
    }
}
