package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, ans;
    static int[][] map;
    static ArrayList<Point> home, chicken, list;

    public static void dfs(int l, int s) {
        if (l == m) {
            int sumDis = 0;
            for (Point h : home) {
                int shortDis = Integer.MAX_VALUE;
                for (Point p : list) {
                    int dis = Math.abs(p.x - h.x) + Math.abs(p.y - h.y);
                    shortDis = Math.min(dis, shortDis);
                }
                sumDis += shortDis;
            }
            ans = Math.min(ans, sumDis);
        } else {
            for (int i = s; i < chicken.size(); i++) {
                list.add(chicken.get(i));
                dfs(l + 1, i + 1);
                list.remove(chicken.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        list = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    home.add(new Point(i, j));
                else if (map[i][j] == 2)
                    chicken.add(new Point(i, j));
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }
}
