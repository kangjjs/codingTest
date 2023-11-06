package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {

    static int r, c, sx, sy, ex, ey;
    static int[][] map;
    static Queue<Point> water;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx, sy));
        boolean[][] visitedWater = new boolean[r][c];
        boolean[][] visitedS = new boolean[r][c];

        for (Point p : water)
            visitedWater[p.x][p.y] = true;
        visitedS[sx][sy] = true;

        int cnt=0;

        while (!q.isEmpty()) {
            for (int i = 0, size = water.size(); i < size; i++) {
                Point cur = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visitedWater[nx][ny] && map[nx][ny] == '.') {
                        visitedWater[nx][ny] = true;
                        water.offer(new Point(nx, ny));
                    }
                }
            }

            for (int i = 0, size = q.size(); i < size; i++) {
                Point cur = q.poll();

                if(cur.x==ex&&cur.y==ey){
                    System.out.println(cnt);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != 'X' && !visitedWater[nx][ny] && !visitedS[nx][ny]) {
                        visitedS[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }

            cnt++;
        }

        System.out.println("KAKTUS");
    }

    public static void main(String[] args) throws IOException {
        B3055 T =new B3055();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        water = new LinkedList<>();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map =new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 'D') {
                    ex = i;
                    ey = j;
                } else if (map[i][j] == '*') {
                    water.offer(new Point(i, j));
                }
            }
        }

        T.bfs();
    }
}
