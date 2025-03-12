package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] pr = new int[k + 1];
		int[] t = new int[k + 1];
		int[][] dp = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			pr[i] = Integer.parseInt(st.nextToken());
			t[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (t[i] <= j)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t[i]] + pr[i]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}

		System.out.println(dp[k][n]);
	}
}
