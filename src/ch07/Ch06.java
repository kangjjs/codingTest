package ch07;

import java.util.LinkedList;
import java.util.Queue;

class Ch06 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    int L = 0;
                    q.offer(new Point(i, j));
                    int[][] ch = new int[r][c];
                    ch[i][j] = 1;

                    while (!q.isEmpty()) {
                        L++;
                        int len = q.size();
                        for (int k = 0; k < len; k++) {
                            Point cur = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = cur.x + dx[l];
                                int ny = cur.y + dy[l];

                                if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1){
                                    if(ch[nx][ny]==0){
                                        ch[nx][ny]=1;
                                        dist[nx][ny] +=L;
                                        q.offer(new Point(nx,ny));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] == 4 && dist[i][j] >0 ){
                    answer = Math.min(answer,dist[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch06 T = new Ch06();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}