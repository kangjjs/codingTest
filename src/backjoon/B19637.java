package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] prize = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            prize[i][0] = st.nextToken();
            prize[i][1] = st.nextToken();
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int lt = 0;
            int rt = n - 1;
            int mid = 0;
            while (lt <= rt) {
                mid = (lt + rt) / 2;

                int x = Integer.parseInt(prize[mid][1]);
                if (x < num) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            sb.append(prize[lt][0]).append('\n');
        }

        System.out.print(sb);
    }
}
