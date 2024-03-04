package ch01;

import java.util.*;

class Ch04 {
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        int[][] seats = new int[r][c];
        if (k > r * c)
            return new int[]{0, 0};
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int d = 0, cnt = 1, x = 0, y = 0;

        while (cnt < k) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || seats[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }

            seats[x][y] = cnt++;
            x = nx;
            y = ny;
        }

        answer[0] = y + 1;
        answer[1] = x + 1;
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
