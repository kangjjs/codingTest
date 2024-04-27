package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FindItem {
    static int[][] map;

    static int bfs(int cx, int cy, int ix, int iy) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cy, cx, 0});
        boolean[][] visited = new boolean[101][101];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == iy && cur[1] == ix)
                return cur[2] / 2;
            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                if (nx < 0 || ny < 0 || ny >= map.length || nx >= map[0].length)
                    continue;
                if (visited[ny][nx] || map[ny][nx] != 2)
                    continue;
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, cur[2] + 1});
            }
        }

        return 0;
    }

    static void makeMap(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (map[i][j] == 1)
                    continue;
                map[i][j] = 1;
                if (i == y1 || i == y2 || j == x1 || j == x2)
                    map[i][j] = 2;
            }
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for (int[] r : rectangle) {
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];
            makeMap(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
}
