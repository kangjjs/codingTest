package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17141 {

    static int n, m, answer = Integer.MAX_VALUE, zeroCnt;
    static int[][] map;
    static Point[] p;
    static boolean[] selected;
    static ArrayList<Point> al;
    static boolean flag;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void dfs(int l, int s) {
        if (l == m) {
            int cnt = bfs();
            answer = Math.min(answer, cnt);
        } else {
            for (int i = s; i < al.size(); i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    p[l] = al.get(i);
                    dfs(l + 1, i);
                    selected[i] = false;
                }
            }
        }
    }

    public int bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] copyMap = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int zero = zeroCnt;
        for (Point x : p) {
            q.offer(x);
            visited[x.x][x.y] = true;
            zero--;
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, n);
        }

        int cnt = 1;
        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && copyMap[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        copyMap[nx][ny] = cnt;
                        zero--;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            cnt++;
        }

        return check(copyMap, zero);
    }

    public int check(int[][] board, int x) {
        int max = 0;
        boolean flags = false;
        if (x == 0) {
            flag = true;
        }else{
            flags=true;
        }

        if(flags){
            max=Integer.MAX_VALUE;
        }else {
            for (int[] y : board) {
                for (int z : y) {
                    max = Math.max(max, z);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        B17141 T = new B17141();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        al = new ArrayList<>();
        p = new Point[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    al.add(new Point(i, j));
                    map[i][j] = 0;
                    zeroCnt++;
                } else if (map[i][j] == 1)
                    map[i][j] = -1;
                else
                    zeroCnt++;
            }
        }
        selected = new boolean[al.size()];
        T.dfs(0, 0);
        System.out.print(flag?answer:-1);
    }
}
