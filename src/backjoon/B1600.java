package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {

    static int k, w, h;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] jumpX = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] jumpY = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cost = start();
        System.out.println(cost);
    }

    static int start() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        boolean[][][] visited = new boolean[h][w][k + 1];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int horse = cur[2];
            int cost = cur[3];

            if (x == h - 1 && y == w - 1)
                return cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 0 && !visited[nx][ny][horse]) {
                    visited[nx][ny][horse] = true;
                    q.add(new int[]{nx, ny, horse, cost + 1});
                }
            }

            if (horse < k) {
                for (int i = 0; i < 8; i++) {
                    int hx = x + jumpX[i];
                    int hy = y + jumpY[i];

                    if (hx >= 0 && hx < h && hy >= 0 && hy < w && map[hx][hy] == 0 && !visited[hx][hy][horse+1]) {
                        visited[hx][hy][horse+1] = true;
                        q.add(new int[]{hx, hy, horse + 1, cost + 1});
                    }
                }
            }
        }

        return -1;
    }
}
