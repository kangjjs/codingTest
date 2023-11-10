package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16918 {

    static int r, c, n, time;
    static char[][] board;
    static int[][] count;
    static Queue<Point> q;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void launchBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                    count[i][j] = time + 3;
                }
            }
        }
    }

    static void explosion() {
        while (!q.isEmpty()) {
            Point cur = q.poll();

            board[cur.x][cur.y] = '.';
            count[cur.x][cur.y] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    count[nx][ny] = 0;
                    board[nx][ny] = '.';
                }
            }
        }
    }

    static void findBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (count[i][j] == time) {
                    q.offer(new Point(i, j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        board = new char[r][c];
        count = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'O') {
                    count[i][j] = 3;
                }
            }
        }

        time = 0;

        while (time++ < n) {
            if (time % 2 == 0) {
                launchBomb();
            }else if(time % 2 ==1){
                findBomb();
                explosion();
            }
        }

        for (char[] x : board) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
