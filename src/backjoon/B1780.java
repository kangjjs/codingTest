package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {

    static int n, cntOne = 0, cntZero = 0, cntMinus = 0;
    static int[][] board;

    public void solution(int x, int y, int s) {
        if (check(x, y, s)) {
            if (board[x][y] == -1)
                cntMinus++;
            else if (board[x][y] == 0)
                cntZero++;
            else if (board[x][y] == 1)
                cntOne++;
        } else {
            s = s / 3;

            int[] dx = {x, x, x, x + s, x + s, x + s, x + 2 * s, x + 2 * s, x + 2 * s};
            int[] dy = {y, y + s, y + 2 * s, y, y + s, y + 2 * s, y, y + s, y + 2 * s};

            for (int i = 0; i < 9; i++) {
                solution(dx[i],dy[i],s);
            }
        }
    }

    public boolean check(int x, int y, int s) {
        if(s==1)
            return true;
        else{
            int z = board[x][y];

            for (int i = x; i < x+s; i++) {
                for (int j = y; j < y+s; j++) {
                    if(z!=board[i][j])
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        B1780 T = new B1780();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(0, 0, n);
        System.out.println(cntMinus);
        System.out.println(cntZero);
        System.out.println(cntOne);
    }
}
