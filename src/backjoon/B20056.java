package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20056 {

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int n, m, k;
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<FireBall> fireBalls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];
        fireBalls = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[r][c] = m;
            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        while (k > 0) {
            move();
            k--;
        }

        System.out.print(sum());
    }

    static void move() {
        List<FireBall>[][] fb = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                fb[i][j] = new ArrayList<>();
            }
        }

        while (!fireBalls.isEmpty()) {
            FireBall cur = fireBalls.poll();
            int c = cur.s;
            int nx = cur.r, ny = cur.c;

            while (c > 0) {
                nx += dx[cur.d];
                ny += dy[cur.d];
                if (nx <= 0)
                    nx = n;
                else if (nx > n)
                    nx = 1;
                if (ny <= 0)
                    ny = n;
                else if (ny > n)
                    ny = 1;
                c--;
            }

            fb[nx][ny].add(new FireBall(nx, ny, cur.m, cur.s, cur.d));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (fb[i][j].isEmpty())
                    continue;
                if (fb[i][j].size() == 1) {
                    fireBalls.add(fb[i][j].get(0));
                    continue;
                }

                int sumM = 0, sumS = 0, sumD = 0;
                boolean even = true, odd = true;

                for (FireBall f : fb[i][j]) {
                    sumM += f.m;
                    sumS += f.s;
                    if (f.d % 2 == 0)
                        odd = false;
                    else
                        even = false;
                }

                int newM = sumM / 5;
                int newS = sumS / fb[i][j].size();
                if (newM == 0)
                    continue;
                int[] dirs = (even || odd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                for (int d : dirs) {
                    fireBalls.add(new FireBall(i, j, newM, newS, d));
                }
            }
        }
    }

    static int sum() {

        int result = 0;

        for (FireBall f : fireBalls) {
            result += f.m;
        }
        return result;
    }
}
