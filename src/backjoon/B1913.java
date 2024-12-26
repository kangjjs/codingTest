package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int s = n * n;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        map[x][y] = s--;
        int idx = 0;
        int[] ans = new int[2];
        while (s > 0) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
                idx = (idx + 1) % 4;
                continue;
            }

            map[nx][ny] = s--;
            if (map[nx][ny] == m) {
                ans = new int[]{nx, ny};
            }
            x = nx;
            y = ny;
        }

        for (int[] ma : map) {
            for (int a : ma) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.print((ans[0] + 1) + " " + (ans[1] + 1));
    }
}
