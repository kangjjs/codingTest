package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2933 {

    static int r, c;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                throwStickFromLeft(r - arr[i]);
            } else {
                throwStickFromRight(r - arr[i]);
            }

            findFloatingClusters();
        }

        printMap();
    }

    static void throwStickFromLeft(int height) {
        for (int j = 0; j < c; j++) {
            if (map[height][j] == 'x') {
                map[height][j] = '.';
                break;
            }
        }
    }

    static void throwStickFromRight(int height) {
        for (int j = c - 1; j >= 0; j--) {
            if (map[height][j] == 'x') {
                map[height][j] = '.';
                break;
            }
        }
    }

    static void findFloatingClusters() {
        boolean[][] visited = new boolean[r][c];

        for (int j = 0; j < c; j++) {
            if (map[r - 1][j] == 'x' && !visited[r - 1][j]) {
                bfs(r - 1, j, visited);
            }
        }

        List<int[]> floating = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    floating.add(new int[]{i, j});
                    map[i][j] = '.';
                }
            }
        }

        if (!floating.isEmpty()) {
            applyGravity(floating);
        }
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void applyGravity(List<int[]> floating) {
        boolean canFall = true;

        while (canFall) {
            for (int[] cur : floating) {
                int x = cur[0] + 1;
                int y = cur[1];

                if (x >= r || map[x][y] == 'x') {
                    canFall = false;
                    break;
                }
            }

            if (canFall) {
                for (int[] cur : floating) {
                    cur[0]++;
                }
            }
        }

        for (int[] cur : floating) {
            map[cur[0]][cur[1]] = 'x';
        }
    }

    static void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
