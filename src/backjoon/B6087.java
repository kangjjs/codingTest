package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class B6087 {

    static int w, h;
    static char[][] map;
    static ArrayList<int[]> lasers = new ArrayList<>();
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        dist = new int[h][w];

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);
                dist[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 'C') {
                    lasers.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int endX = lasers.get(1)[0];
        int endY = lasers.get(1)[1];
        System.out.println(dist[endX][endY]);
    }

    static void bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        int startX = lasers.get(0)[0];
        int startY = lasers.get(0)[1];

        deque.add(new int[]{startX, startY, -1});
        dist[startX][startY] = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];
            int dir = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while(true){
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '*') {
                        break;
                    }

                    int mirrors = (dir == -1 || dir == i) ? dist[x][y] : dist[x][y] + 1;

                    if (dist[nx][ny] > mirrors) {
                        dist[nx][ny] = mirrors;
                        if (dir == i || dir == -1) {
                            deque.addFirst(new int[]{nx, ny, i});
                        } else {
                            deque.addLast(new int[]{nx, ny, i});
                        }
                    }
                }
            }
        }
    }
}