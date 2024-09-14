package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_M_417 {

    static int w, h;
    static boolean[][] visitedPacific, visitedAtlantic;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    void dfs(int x, int y, boolean[][] visited, int[][] heights) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                dfs(nx, ny, visited, heights);
            }
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        w = heights[0].length;
        h = heights.length;
        visitedAtlantic = new boolean[h][w];
        visitedPacific = new boolean[h][w];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            dfs(0, i, visitedPacific, heights);
            dfs(h - 1, i, visitedAtlantic, heights);
        }

        for (int i = 0; i < h; i++) {
            dfs(i, 0, visitedPacific, heights);
            dfs(i, w - 1, visitedAtlantic, heights);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }
}
