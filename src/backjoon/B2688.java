package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2688 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[65][10];

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int k = 2; k <= 64; k++) {
			for (int i = 0; i <= 9; i++) {
				for (int j = i; j <= 9; j++) {
					dp[k][i] += dp[k - 1][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long ans = 0;

			for (int j = 0; j <= 9; j++) {
				ans += dp[n][j];
			}

			sb.append(ans).append('\n');
		}

		System.out.print(sb);
	}
}
