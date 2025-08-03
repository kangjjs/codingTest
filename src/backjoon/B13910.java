package backjoon;

import java.io.*;
import java.util.*;

public class B13910 {
    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> wokCount = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int size = Integer.parseInt(st.nextToken());
            wokCount.put(size, wokCount.getOrDefault(size, 0) + 1);
        }

        List<Integer> wokList = new ArrayList<>(wokCount.keySet());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int size : wokList) {
            for (int i = size; i <= n; i++) {
                if (dp[i - size] != INF)
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
            }
        }

        for (int i = 0; i < wokList.size(); i++) {
            for (int j = i; j < wokList.size(); j++) {
                int a = wokList.get(i);
                int b = wokList.get(j);

                if (a == b && wokCount.get(a) < 2) continue;

                int sum = a + b;
                for (int k = sum; k <= n; k++) {
                    if (dp[k - sum] != INF)
                        dp[k] = Math.min(dp[k], dp[k - sum] + 1);
                }
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}
