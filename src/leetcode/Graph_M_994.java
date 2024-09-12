package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_M_994 {
    public int orangesRotting(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if (cnt == 0)
            return 0;
        if (cnt > 0 && q.isEmpty())
            return -1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 0;
        while (!q.isEmpty() && cnt > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        cnt--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }

        return cnt == 0 ? ans : -1;
    }
}
