package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2624 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] p = new int[k];
		int[] n = new int[k];

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			n[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[k + 1][t + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= t; j++) {
				dp[i][j] = dp[i - 1][j];
				for (int l = 1; l <= n[i - 1]; l++) {
					if (j >= l * p[i - 1]) {
						dp[i][j] += dp[i - 1][j - l * p[i - 1]];
					}
				}
			}
		}

		System.out.println(dp[k][t]);
	}
}
