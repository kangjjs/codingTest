package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B2667Bfs {

    static int n, answer = 0, cnt = 1;
    static int[][] board;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Point> queue = new LinkedList<>();

    public void bfs(int x, int y) {
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx>=0&&nx<n&&ny>=0&&ny<n&&board[nx][ny]==1){
                    board[nx][ny]=0;
                    cnt++;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }

    public void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    answer++;
                    bfs(i, j);
                    arrayList.add(cnt);
                    cnt = 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        B2667Bfs T = new B2667Bfs();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        T.solution();
        Collections.sort(arrayList);

        System.out.println(answer);
        for (int x : arrayList) {
            System.out.println(x);
        }
    }
}

