package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {

    public static int white = 0;
    public static int black = 0;
    public static int[][] board;

    public static void solution(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                black++;
            }
            return;
        }

        int newSize = size / 2;
        solution(row, col, newSize);
        solution(row, col + newSize, newSize);
        solution(row + newSize, col, newSize);
        solution(row + newSize, col + newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0,N);
        System.out.println(white);
        System.out.println(black);
    }
}
