package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {

    static int n;
    static int[][] area;
    static boolean[][] check;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void bfs(int x, int y, int k) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        check[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && area[nx][ny] > k && !check[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }
    }

    public int solution(int k) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] > k && !check[i][j]) {
                    answer++;
                    bfs(i, j, k);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                check[i][j]=false;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        B2468 T = new B2468();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int ans = 0;
        area = new int[n][n];
        check = new boolean[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, area[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            ans = Math.max(ans, T.solution(i));
        }

        System.out.print(ans);
    }
}
