package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] cows = new int[n];
        int[] jokes = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            jokes[i] = Integer.parseInt(st.nextToken());
        }

        long[] P = new long[n];
        for (int i = 0; i < n; i++) {
            long mul = 1;
            for (int k = 0; k < 4; k++) {
                mul *= cows[(i + k) % n];
            }
            P[i] = mul;
        }
        long S = 0;
        for (long v : P) S += v;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int idx = jokes[i] - 1;

            for (int d = 0; d < 4; d++) {
                int p = idx - d;
                if (p < 0) p += n;
                S -= 2L * P[p];
                P[p] = -P[p];
            }

            sb.append(S).append('\n');
        }

        System.out.print(sb);
    }
}