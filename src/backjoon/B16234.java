package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 {

    static int n, l, r;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static ArrayList<Point> list;

    static public int solution() {
        int cnt = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            flag = true;
                            move(sum);
                        }
                    }
                }
            }

            if (!flag)
                return cnt;
            cnt++;
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        list.add(new Point(x, y));
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int sum = board[x][y];

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (Math.abs(board[cur.x][cur.y] - board[nx][ny]) >= l && Math.abs(board[cur.x][cur.y] - board[nx][ny]) <= r) {
                        visited[nx][ny] = true;
                        sum += board[nx][ny];
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                    }
                }
            }
        }

        return sum;
    }

    static void move(int sum) {

        int avg = sum / list.size();

        for (Point p : list) {
            board[p.x][p.y] = avg;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
