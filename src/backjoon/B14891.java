package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891 {

    static char[][] cogWheels;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cogWheels = new char[5][9];
        for (int i = 1; i <= 4; i++) {
            String wheel = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogWheels[i][j + 1] = wheel.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            visited = new boolean[5];

            if (turn == 1) {
                rotate(num);
            } else
                unrotate(num);
        }

        int ans = 0;

        for (int i = 1; i <= 4; i++) {
            ans += get(i);
        }

        System.out.println(ans);
    }

    static void rotate(int cur) {
        visited[cur] = true;
        int left = cur - 1;
        int right = cur + 1;

        if (left >= 1 && !visited[left]) {
            if (cogWheels[left][3] != cogWheels[cur][7]) {
                unrotate(left);
            }
        }

        if (right <= 4 && !visited[right]) {
            if (cogWheels[right][7] != cogWheels[cur][3]) {
                unrotate(right);
            }
        }

        for (int i = 8; i >= 1; i--) {
            if (i == 8) {
                cogWheels[cur][0] = cogWheels[cur][8];
            }

            cogWheels[cur][i] = cogWheels[cur][i - 1];
        }
    }

    static void unrotate(int cur) {
        visited[cur] = true;
        int left = cur - 1;
        int right = cur + 1;

        if (left >= 1 && !visited[left]) {
            if (cogWheels[left][3] != cogWheels[cur][7]) {
                rotate(left);
            }
        }

        if (right <= 4 && !visited[right]) {
            if (cogWheels[right][7] != cogWheels[cur][3]) {
                rotate(right);
            }
        }

        for (int i = 0; i <= 8; i++) {
            if (i == 8) {
                cogWheels[cur][8] = cogWheels[cur][0];
                continue;
            }
            cogWheels[cur][i] = cogWheels[cur][i + 1];
        }
    }

    static int get(int i) {
        if (cogWheels[i][1] == '1') {
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 4;
                case 4:
                    return 8;
            }
        }

        return 0;
    }
}
