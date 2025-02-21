package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		int[] coins = {1, 2, 5, 7};
		for (int i = 0; i < 4; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
			}
		}

		System.out.println(dp[n]);
	}
}
