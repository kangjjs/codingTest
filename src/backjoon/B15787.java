package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15787 {

    static int n, m;
    static int[][] train;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        train = new int[n + 1][21];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int seat;
            switch (order) {
                case 1:
                    seat = Integer.parseInt(st.nextToken());
                    if (train[num][seat] == 0)
                        train[num][seat] = 1;
                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken());
                    if (train[num][seat] == 1)
                        train[num][seat] = 0;
                    break;
                case 3:
                    move(num);
                    break;
                case 4:
                    move2(num);
                    break;
            }
        }

        Set<String> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                sb.append(train[i][j]);
            }

            set.add(sb.toString());
        }

        System.out.println(set.size());
    }

    static void move(int num) {
        for (int i = 20; i >= 2; i--) {
            train[num][i] = train[num][i - 1];
        }

        train[num][1] = 0;
    }

    static void move2(int num) {
        for (int i = 1; i < 20; i++) {
            train[num][i] = train[num][i + 1];
        }

        train[num][20] = 0;
    }
}
