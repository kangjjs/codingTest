package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15662 {

    static int t;
    static char[][] wheels;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        wheels = new char[t + 1][9];

        for (int i = 1; i <= t; i++) {
            String wheel = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j + 1] = wheel.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[t + 1];
            rotate(num, dir);
        }

        int ans = cnt();
        System.out.println(ans);
    }

    static void rotate(int num, int dir) {
        visited[num] = true;
        int left = num - 1;
        int right = num + 1;

        if (left >= 1 && wheels[left][3] != wheels[num][7] && !visited[left]) {
            rotate(left, -dir);
        }

        if (right <= t && wheels[right][7] != wheels[num][3] && !visited[right]) {
            rotate(right, -dir);
        }

        if (dir == 1) {
            for (int i = 8; i >= 1; i--) {
                if (i == 8) {
                    wheels[num][0] = wheels[num][8];
                }

                wheels[num][i] = wheels[num][i - 1];
            }
        } else {
            for (int i = 0; i <= 8; i++) {
                if (i == 8) {
                    wheels[num][8] = wheels[num][0];
                    continue;
                }
                wheels[num][i] = wheels[num][i + 1];
            }
        }
    }

    static int cnt() {
        int result = 0;
        for (int i = 1; i <= t; i++) {
            if (wheels[i][1] == '1')
                result++;
        }

        return result;
    }
}
