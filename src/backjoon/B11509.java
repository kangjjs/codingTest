package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] balloon = new int[1000002];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (balloon[x + 1] > 0) {
                balloon[x + 1]--;
            }
            balloon[x]++;
        }

        int ans = 0;
        for (int x : balloon) {
            if (x > 0) {
                ans += x;
            }
        }

        System.out.println(ans);
    }
}
