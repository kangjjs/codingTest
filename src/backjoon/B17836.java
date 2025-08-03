package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                if(cur[3]<=t)
                    ans = Math.min(ans,cur[3]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (cur[2] == 0) {
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1 && !visited[nx][ny][0]) {
                        if (map[nx][ny] == 2) {
                            q.add(new int[]{nx, ny, 1, cur[3] + 1});
                            visited[nx][ny][1] = true;
                        }else {
                            q.add(new int[]{nx, ny, 0, cur[3] + 1});
                            visited[nx][ny][0] = true;
                        }
                    }
                } else {
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][1]) {
                        q.add(new int[]{nx, ny, 1, cur[3] + 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        if(ans==Integer.MAX_VALUE)
            System.out.println("Fail");
        else
            System.out.println(ans);
    }
}
