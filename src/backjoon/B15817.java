package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] L = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[X + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            long[] next = new long[X+1];
            for (int len = 0; len <= X; len++) {
                long ways = dp[len];
                if (ways == 0) continue;

                for (int k = 0; k <= C[i]; k++) {
                    int nl = len + k * L[i];
                    if (nl > X) break;
                    next[nl] += ways;
                }
            }
            dp = next;
        }

        System.out.println(dp[X]);
    }
}
