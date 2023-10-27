package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16956 {

    static int n, m;
    static char[][] board;
    static Queue<Point> q = new LinkedList<>();
    static boolean flag = true;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == '.')
                        board[nx][ny] = 'D';
                    if (board[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B16956 T = new B16956();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == 'W')
                    q.offer(new Point(i, j));
            }
        }

        T.solution();

        if (flag) {
            System.out.println("1");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("0");
        }
    }
}
