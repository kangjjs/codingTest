package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {

    static int n, m, answer = 0;
    static int[][] map;
    static Queue<Point> q;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solution(int l) {
        if (l == 3) {
            int[][] spread = spread();
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (spread[i][j] == 0)
                        cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        solution(l + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public int[][] spread() {
        Queue<Point> sq = new LinkedList<>(q);

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        while (!sq.isEmpty()) {
            Point p = sq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx>=0&&nx<n&&ny>=0&&ny<m&&copy[nx][ny]==0){
                    copy[nx][ny]=2;
                    sq.offer(new Point(nx,ny));
                }
            }
        }

        return copy;
    }


    public static void main(String[] args) throws IOException {
        B14502 T = new B14502();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    q.add(new Point(i, j));
            }
        }

        T.solution(0);

        System.out.println(answer);
    }
}
