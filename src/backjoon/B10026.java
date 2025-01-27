package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {

    static int n, ans1, ans2;
    static char[][] map;
    static boolean[][] normal, redGreen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        ans1 = 0;
        ans2 = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        normal = new boolean[n][n];
        redGreen = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!normal[i][j]) {
                    normalBfs(i, j);
                    ans1++;
                }

                if (!redGreen[i][j]) {
                    redGreenBfs(i, j);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    static void normalBfs(int x, int y) {
        normal[x][y] = true;
        char c = map[x][y];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !normal[nx][ny] && map[nx][ny] == c) {
                    normal[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void redGreenBfs(int x, int y) {
        redGreen[x][y] = true;
        char c = map[x][y];
        boolean flag = c == 'B';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !redGreen[nx][ny]) {
                    if (flag) {
                        if (map[nx][ny] == 'B') {
                            redGreen[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    } else {
                        if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                            redGreen[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
