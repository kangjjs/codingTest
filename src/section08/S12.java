package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S12 {

    static int n, m;
    static int[][] board, dis;
    static Queue<Point> queue = new LinkedList<>();

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        S12 T = new S12();
        Scanner kb = new Scanner(System.in);

        int answer = Integer.MIN_VALUE;
        m = kb.nextInt();
        n = kb.nextInt();

        board = new int[n][m];
        dis = new int[n][m];

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                } else
                    flag = false;
            }
        }

        if (flag) {
            System.out.print(0);
            return;
        }

        T.solution();
        boolean t = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    t = false;
                    break;
                }
            }
        }

        if (t) {
            for (int i = 0; i < n; i++){
                for(int j=0;j<m;j++){
                    answer=Math.max(answer,dis[i][j]);
                }
            }

            System.out.print(answer);
        }else{
            System.out.print(-1);
        }
    }
}
