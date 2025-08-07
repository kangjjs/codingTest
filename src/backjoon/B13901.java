package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13901 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        ArrayList<int[]> blocks = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            blocks.add(new int[]{bx, by});
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        int[] dir = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[r][c];
        for (int[] block : blocks) {
            map[block[0]][block[1]] = -1;
        }

        map[sr][sc] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int idx = 0, cnt = 0;

        while (true) {
            int d = dir[idx]-1;
            int nx = sr + dx[d];
            int ny = sc + dy[d];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] != 0) {
                cnt++;
                if (cnt == 4)
                    break;
                idx = (idx + 1) % 4;
                continue;
            }

            map[nx][ny] = 1;
            sr = nx;
            sc = ny;
            cnt = 0;
        }

        System.out.print(sr + " " + sc);
    }
}
