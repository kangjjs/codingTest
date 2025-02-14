package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}

		System.out.print(sb);
	}
}
