package ch08;

import java.util.Arrays;
import java.util.PriorityQueue;

class Ch05 {

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int[][] board, int[] s, int[] e) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(s[0], s[1], 0));
        int[][] costs = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[s[0]][s[1]] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.cost > costs[cur.x][cur.y])
                continue;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;
                int cost = cur.cost;

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    cost++;
                }

                nx -= dx[i];
                ny -= dy[i];
                cost--;

                if (costs[nx][ny] > cost) {
                    costs[nx][ny] = cost;
                    pq.offer(new Point(nx, ny, cost));
                }
            }
        }

        return costs[e[0]][e[1]] == Integer.MAX_VALUE ? -1 : costs[e[0]][e[1]];
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}