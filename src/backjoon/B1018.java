package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {

    static int n, m, ans;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                ans = Math.min(ans, find(i, j));
            }
        }

        System.out.println(ans);
    }

    static int find(int x, int y) {
        int wStart = 0;
        int bStart = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (map[i][j] != 'W')
                        wStart++;
                    if (map[i][j] != 'B')
                        bStart++;
                } else {
                    if (map[i][j] != 'W')
                        bStart++;
                    if (map[i][j] != 'B')
                        wStart++;
                }
            }
        }

        return Math.min(wStart, bStart);
    }
}
