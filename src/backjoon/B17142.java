package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17142 {

    static int n, m, zeroCnt, answer = Integer.MAX_VALUE;
    static ArrayList<Point> virusList;
    static int[][] map;
    static Point[] points;
    static boolean flagVirus = false;
    static boolean[] selectedVirus;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void dfs(int l, int s) {
        if (l == m) {
            int cnt = bfs();
            answer = Math.min(answer, cnt);
        } else {
            for (int i = s; i < virusList.size(); i++) {
                if (!selectedVirus[i]) {
                    selectedVirus[i] = true;
                    points[l] = virusList.get(i);
                    dfs(l + 1, i);
                    selectedVirus[i] = false;
                }
            }
        }
    }

    public int bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] copyMap = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int zero = zeroCnt;

        if (zeroCnt == 0) {
            flagVirus = true;
            return 0;
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, n);
        }

        for (Point p : points) {
            q.offer(p);
            copyMap[p.x][p.y] = 0;
            visited[p.x][p.y] = true;
        }

        int cnt = 0;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {
                Point p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        if (copyMap[nx][ny] == 0) {
                            copyMap[nx][ny] = cnt + 1;
                            visited[nx][ny] = true;
                            zero--;
                            q.offer(new Point(nx, ny));

                            if (zero == 0) {
                                flagVirus = true;
                                return checkVirus(copyMap);
                            }
                        }

                        if (copyMap[nx][ny] == -2) {
                            copyMap[nx][ny] = cnt + 1;
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            cnt++;
        }

        return Integer.MAX_VALUE;
    }

    public int checkVirus(int[][] copyMap) {
        int max = 0;
        for (int[] x : copyMap) {
            for (int y : x) {
                max = Math.max(max, y);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        B17142 T = new B17142();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virusList = new ArrayList<>();
        map = new int[n][n];
        points = new Point[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virusList.add(new Point(i, j));
                    map[i][j] = -2;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                } else
                    zeroCnt++;
            }
        }

        selectedVirus = new boolean[virusList.size()];
        T.dfs(0, 0);
        System.out.print(flagVirus ? answer : -1);
    }
}
