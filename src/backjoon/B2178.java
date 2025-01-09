package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == n - 1 && cur[1] == m - 1)
                    return ans;
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '1' && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            ans++;
        }

        return 0;
    }
}