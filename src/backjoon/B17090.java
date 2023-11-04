package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17090 {
    static int n, m;
    static char[][] maze;
    static boolean[][] visited;
    static boolean[][] escapable;

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }

        if (visited[x][y]) {
            return escapable[x][y];
        }

        visited[x][y] = true;
        char ch = maze[x][y];

        int dx = 0, dy = 0;
        switch (ch) {
            case 'U':
                dx = -1;
                break;
            case 'D':
                dx = 1;
                break;
            case 'L':
                dy = -1;
                break;
            case 'R':
                dy = 1;
                break;
        }

        escapable[x][y] = dfs(x + dx, y + dy);
        return escapable[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new char[n][m];
        visited = new boolean[n][m];
        escapable = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

