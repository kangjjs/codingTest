package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][m];

            Queue<int[]> me = new LinkedList<>();
            Queue<int[]> fires = new LinkedList<>();
            boolean[][] visitedMe = new boolean[n][m];
            boolean[][] visitedFire = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = str.charAt(j);
                    map[i][j] = c;
                    if (c == '@') {
                        me.add(new int[]{i, j});
                        visitedMe[i][j] = true;
                    } else if (c == '*') {
                        fires.add(new int[]{i, j});
                        visitedFire[i][j] = true;
                    }
                }
            }

            int cnt = 0;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            boolean escaped = false;

            while (!me.isEmpty()) {
                int fireSize = fires.size();

                for (int j = 0; j < fireSize; j++) {
                    int[] curFire = fires.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = curFire[0] + dx[k];
                        int ny = curFire[1] + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visitedFire[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                            fires.add(new int[]{nx, ny});
                            visitedFire[nx][ny] = true;
                            map[nx][ny] = '*';
                        }
                    }
                }

                int meSize = me.size();

                for (int j = 0; j < meSize; j++) {
                    int[] curMe = me.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = curMe[0] + dx[k];
                        int ny = curMe[1] + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            cnt++;
                            escaped = true;
                            break;
                        }

                        if (map[nx][ny] == '.' && !visitedMe[nx][ny]) {
                            visitedMe[nx][ny] = true;
                            me.add(new int[]{nx, ny});
                        }
                    }
                    if (escaped)
                        break;
                }
                if (escaped)
                    break;
                cnt++;
            }

            if (escaped)
                sb.append(cnt).append('\n');
            else
                sb.append("IMPOSSIBLE").append('\n');
        }

        System.out.print(sb);
    }
}
