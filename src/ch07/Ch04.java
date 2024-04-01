package ch07;

import java.util.LinkedList;
import java.util.Queue;

class Ch04 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        board[0][0] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();

                if(p.x==6&&p.y==6)
                    return answer;

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        board[nx][ny] = 1;
                    }
                }
            }

            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch04 T = new Ch04();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}