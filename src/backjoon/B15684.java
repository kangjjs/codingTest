package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15684 {

    static int n, m, h, ans = 4;
    static int[][] ladder;

    public static void solution(int x, int l) {
        if (ans <= l)
            return;
        else {
            if (check()) {
                ans = l;
                return;
            }
        }

        for (int i = x; i < h + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;
                    solution(i, l + 1);
                    ladder[i][j] = ladder[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= n; i++) {
            int x = 1, y = i;
            for (int j = 0; j < h; j++) {
                if (ladder[x][y] == 1)
                    y++;
                else if (ladder[x][y] == 2)
                    y--;
                x++;
            }

            if (y != i)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 1;
            ladder[a][b + 1] = 2;
        }

        solution(1, 0);
        System.out.print((ans != 4) ? ans : -1);
    }
}
