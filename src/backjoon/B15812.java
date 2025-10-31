package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15812 {

    static int n, m, ans, town;
    static char[][] map;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        ans = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '1')
                    town++;
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int l) {
        if (l == 2) {
            ans = Math.min(ans, bfs());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    list.add(new int[]{i, j});
                    dfs(l + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int[] x : list) {
            q.add(x);
            visited[x[0]][x[1]] = true;
        }

        int t = town;
        int cnt = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int size = q.size();

            if(t==0){
                break;
            }

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny])
                        continue;
                    if(map[nx][ny]=='1'){
                        t--;
                    }

                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }

            cnt++;
        }

        return cnt;
    }
}
