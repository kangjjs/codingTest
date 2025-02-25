package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15990 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MOD = 1000000009;
		long[][] dp = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int j = 0; j < t; j++) {
			int w = Integer.parseInt(br.readLine());
			long res = (dp[w][1] + dp[w][2] + dp[w][3]) % MOD;
			sb.append(res).append('\n');
		}

		System.out.print(sb);
	}
}