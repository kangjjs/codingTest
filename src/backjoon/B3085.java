package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3085 {

    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                ans = Math.max(ans, check());
                swap(i, j + 1, i, j);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                ans = Math.max(ans, check());
                swap(i + 1, j, i, j);
            }
        }

        System.out.println(ans);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }

    static int check() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
        }

        return max;
    }
}
