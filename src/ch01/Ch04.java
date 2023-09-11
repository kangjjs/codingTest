package ch01;

import java.util.Arrays;

public class Ch04 {
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];

        if (k > c * r)
            return new int[]{0, 0};

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] board = new int[c][r];

        int x = 0, y = 0, count = 1, i = 0;

        while (count < k) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] > 0) {
                i = (i + 1) % 4;
                continue;
            }

            board[x][y] = count;
            count++;
            x = nx;
            y = ny;

        }

        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }

    public static void main(String[] args) {
        Ch04 T = new Ch04();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
