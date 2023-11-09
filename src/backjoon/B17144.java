package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dust {
    public int x, y, dust;

    public Dust(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}

public class B17144 {

    static int r, c, t, sx, ex;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static Queue<Dust> q;

    static void check() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 0 && board[i][j] != -1) {
                    q.offer(new Dust(i, j, board[i][j] / 5));
                }
            }
        }
    }

    static void spread() {
        q = new LinkedList<>();
        check();
        while (!q.isEmpty()) {
            Dust cur = q.poll();

            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != -1) {
                    board[nx][ny] += cur.dust;
                    cnt++;
                }
            }
            board[cur.x][cur.y] -= cur.dust * cnt;
        }
    }

    static void move() {
        for (int i = sx - 1; i > 0; i--)
            board[i][0] = board[i - 1][0];
        for (int i = 0; i < c - 1; i++)
            board[0][i] = board[0][i + 1];
        for (int i = 0; i < sx; i++)
            board[i][c - 1] = board[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[sx][i] = board[sx][i - 1];
        board[sx][1] = 0;

        for (int i = ex + 1; i < r - 1; i++)
            board[i][0] = board[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            board[r - 1][i] = board[r - 1][i + 1];
        for (int i = r - 1; i > ex; i--)
            board[i][c - 1] = board[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            board[ex][i] = board[ex][i - 1];
        board[ex][1] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        boolean flag = true;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) {
                    if (flag) {
                        sx = i;
                        flag = false;
                    } else
                        ex = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spread();
            move();
        }

        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != -1 && board[i][j] != 0)
                    ans += board[i][j];
            }
        }

        System.out.println(ans);
    }
}
