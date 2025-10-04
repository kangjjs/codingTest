package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14620 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, ans;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> list;
    static int[] dx = {1, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        ans = Integer.MAX_VALUE;
        visited = new boolean[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int l, int sum) {
        if (l == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (can(i, j)) {
                    int cost = plant(i, j, true);
                    dfs(l+1,sum+cost);
                    plant(i,j,false);
                }
            }
        }
    }

    static boolean can(int i, int j) {
        for (int k = 0; k < 5; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (visited[nx][ny])
                return false;
        }

        return true;
    }

    static int plant(int i, int j, boolean flag) {
        int sum = 0;
        for (int k = 0; k < 5; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            visited[nx][ny] = flag;
            sum+= map[nx][ny];
        }

        return sum;
    }
}
