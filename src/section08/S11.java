package section08;

import java.util.*;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class S11 {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    static int[][] map, dis;
    Queue<Point> queue = new LinkedList<>();

    public void solution(int x, int y) {
        map[1][1] = 1;
        queue.offer(new Point(1, 1));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        S11 T = new S11();
        Scanner kb = new Scanner(System.in);

        map = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        T.solution(1, 1);

        if (dis[7][7] == 0)
            System.out.print(-1);
        else
            System.out.print(dis[7][7]);
    }
}

