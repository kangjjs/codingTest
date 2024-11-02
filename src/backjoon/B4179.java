package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        Queue<int[]> j = new LinkedList<>();
        Queue<int[]> f = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < m; k++) {
                map[i][k] = str.charAt(k);
                if (map[i][k] == 'J') {
                    j.add(new int[]{i, k});
                    visited[i][k] = true;
                } else if (map[i][k] == 'F')
                    f.add(new int[]{i, k});
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int ans = 0;
        while (!j.isEmpty()) {
            int sizeF = f.size();
            for (int i = 0; i < sizeF; i++) {
                int[] cur = f.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] =='.') {
                        f.add(new int[]{nx, ny});
                        map[nx][ny] = 'F';
                    }
                }
            }

            int sizeJ = j.size();
            for (int i = 0; i < sizeJ; i++) {
                int[] cur = j.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        System.out.println(++ans);
                        return;
                    }

                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        j.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            ans++;
        }

        System.out.println("IMPOSSIBLE");
    }
}
