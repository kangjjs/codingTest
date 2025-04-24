package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2780 {

	static final int MOD = 1234567;
	static final int[][] adjacent = {
		{7},
		{2, 4},
		{1, 3, 5},
		{2, 6},
		{1, 5, 7},
		{2, 4, 6, 8},
		{3, 5, 9},
		{0, 4, 8},
		{5, 7, 9},
		{6, 8}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n + 1][10];

			for (int i = 0; i <= 9; i++) {
				dp[1][i] = 1;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int next : adjacent[j]) {
						dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
					}
				}
			}

			int total = 0;
			for (int i = 0; i <= 9; i++) {
				total = (total + dp[n][i]) % MOD;
			}
			sb.append(total).append('\n');
		}

		System.out.print(sb);
	}
}
