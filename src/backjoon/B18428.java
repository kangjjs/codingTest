package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18428 {

    static boolean flag;
    static int n;
    static char[][] map;
    static List<int[]> students, empty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        students = new ArrayList<>();
        empty = new ArrayList<>();
        flag = false;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X')
                    empty.add(new int[]{i, j});
                if (map[i][j] == 'S')
                    students.add(new int[]{i, j});
            }
        }

        dfs(0, 0);

        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void dfs(int l, int s) {
        if (flag)
            return;
        if (l == 3) {
            if (check()) {
                flag = true;
            }

            return;
        }

        for (int i = s; i < empty.size(); i++) {
            int[] cur = empty.get(i);
            map[cur[0]][cur[1]] = 'O';
            dfs(l + 1, i + 1);
            map[cur[0]][cur[1]] = 'X';
        }
    }

    static boolean check() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int[] student : students) {
            int x = student[0];
            int y = student[1];

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx == n || ny < 0 || ny == n)
                        break;
                    if (map[nx][ny] == 'T')
                        return false;
                    if (map[nx][ny] == 'O')
                        break;
                }
            }
        }

        return true;
    }
}
