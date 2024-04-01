package ch07;

import java.util.LinkedList;
import java.util.Queue;

class Ch05 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int[][] dist = new int[n][n];
        Queue<Point> q = new LinkedList<>();
        int empty = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    int L = 0;
                    answer = Integer.MAX_VALUE;
                    q.offer(new Point(i, j));

                    while (!q.isEmpty()) {
                        L++;
                        int len = q.size();
                        for (int k = 0; k < len; k++) {
                            Point cur = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = cur.x + dx[l];
                                int ny = cur.y + dy[l];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == empty) {
                                    board[nx][ny]--;
                                    dist[nx][ny] += L;
                                    q.offer(new Point(nx, ny));
                                    answer = Math.min(answer, dist[nx][ny]);
                                }
                            }
                        }
                    }

                    empty--;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
