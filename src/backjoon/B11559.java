package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B11559 {
    static int ans;
    static char[][] board;
    static boolean[][] visited;
    static boolean flag;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    ArrayList<Point> list = new ArrayList<>();
                    char ch = board[i][j];
                    list.add(new Point(i, j));
                    q.offer(new Point(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Point cur = q.poll();


                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && board[nx][ny] == ch && !visited[nx][ny]) {
                                q.offer(new Point(nx, ny));
                                list.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    if(list.size()>=4){
                        for (Point point : list) {
                            board[point.x][point.y] = '.';
                            move(point.x, point.y);
                            flag=true;
                        }
                    }
                }
            }
        }
    }

    static void move(int x, int y) {
        for (int i = x; i > 0; i--) {
            board[i][y] = board[i-1][y];
        }
        board[0][y]='.';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        while (true) {
            flag = false;
            bfs();
            if (!flag)
                break;
            ans++;
        }

        System.out.println(ans);
    }
}
