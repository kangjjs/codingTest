package ch01;

import java.util.*;

class Ch03 {
    public int solution(int[][] board) {
        int answer = 0;

        int dogX = 0, dogY = 0, hX = 0, hY = 0;
        int dogD = 0, hD = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    hX = i;
                    hY = j;
                }
                if (board[i][j] == 3) {
                    dogX = i;
                    dogY = j;
                }
            }
        }

        while (answer<10000) {
            answer++;

            int x = dogX + dx[dogD];
            int y = dogY + dy[dogD];

            int px = hX + dx[hD];
            int py = hY + dy[hD];

            if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) {
                dogD = (dogD + 1) % 4;
            } else {
                dogX = x;
                dogY = y;
            }

            if (px < 0 || px >= n || py < 0 || py >= n || board[px][py] == 1) {
                hD = (hD + 1) % 4;
            } else {
                hX = px;
                hY = py;
            }

            if(dogX==hX&&dogY==hY)
                break;
        }

        if (answer >= 10000) {
            return 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}