package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615 {

    static int[][] board;
    static int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    if (check(i, j, board[i][j])) {
                        System.out.println(board[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean check(int x, int y, int v) {
        for (int i = 0; i < 4; i++) {
            int dx = direction[i][0];
            int dy = direction[i][1];

            int count = 1;
            int nx = x + dx;
            int ny = y + dy;

            while (inRange(nx, ny) && board[nx][ny] == v) {
                count++;
                nx += dx;
                ny += dy;
            }

            int px = x - dx;
            int py = y - dy;
            if (inRange(px, py) && board[px][py] == v) {
                continue;
            }

            if (inRange(nx, ny) && board[nx][ny] == v) {
                continue;
            }

            if (count == 5)
                return true;
        }

        return false;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}