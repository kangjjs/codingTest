package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> tetra = new ArrayList<>();
        int sum = 0;
        for (int i = 1; ; i++) {
            sum += i * (i + 1) / 2;
            if (sum > n) break;
            tetra.add(sum);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int t : tetra) {
            for (int i = t; i <= n; i++) {
                if (dp[i - t] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - t] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
