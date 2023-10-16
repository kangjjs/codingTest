package section08;

import java.util.*;

class S12 {

    static int n, m;
    static int[][] board, dis;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();

    public void solution() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        S12 T = new S12();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        board = new int[m][n];
        dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
                if (board[i][j] == 1)
                    q.offer(new Point(i, j));
            }
        }
        T.solution();

        boolean flag = true;
        int ans = Integer.MIN_VALUE;

        for (int[] x : board) {
            for (int y : x) {
                if (y == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            for (int[] x : dis) {
                for (int y : x) {
                    ans = Math.max(ans, y);
                }
            }
            System.out.print(ans);
        } else {
            System.out.print(-1);
        }
    }
}
