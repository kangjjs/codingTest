package backjoon;

import java.io.*;
import java.util.*;

public class B22115 {
    static final int INF = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] caffeine = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            caffeine[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int c = caffeine[i];
            for (int j = K; j >= c; j--) {
                if (dp[j - c] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
