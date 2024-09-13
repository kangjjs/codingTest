package leetcode;

class Graph_M_79 {
    static int w, h;
    static boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean flag = false;

    void dfs(int x, int y, int l, String word, char[][] board) {
        if (flag) {
            return;
        }
        if (l == word.length()) {
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] || board[nx][ny] != word.charAt(l))
                continue;
            visited[nx][ny] = true;
            dfs(nx, ny, l + 1, word, board);
            visited[nx][ny] = false;
        }
    }


    public boolean exist(char[][] board, String word) {
        w = board[0].length;
        h = board.length;
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    dfs(i, j, 1, word, board);
                    visited[i][j] = false;
                    if (flag)
                        return true;
                }
            }
        }

        return flag;
    }
}
