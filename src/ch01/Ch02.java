package ch01;

import java.util.*;

class Ch02 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int cnt = 0;
        int x = 0, y = 0, d = 0;

        while (cnt < k) {
            cnt++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny] == 1) {
                if (d == 3) d = 0;
                else d++;
                continue;
            }

            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}