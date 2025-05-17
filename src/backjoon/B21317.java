package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21317 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] jump = new int[n][2];
		int[] dp = new int[n + 1];

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jump[i][0] = Integer.parseInt(st.nextToken());
			jump[i][1] = Integer.parseInt(st.nextToken());
		}

		int k = Integer.parseInt(br.readLine());

		if (n >= 2)
			dp[2] = jump[1][0];
		if (n >= 3)
			dp[3] = Math.min(dp[2] + jump[2][0], jump[1][1]);

		int answer = Integer.MAX_VALUE;

		if (n >= 4) {
			for (int i = 4; i <= n; i++) {
				for (int j = 4; j <= n; j++) {
					if (i == j)
						dp[j] = dp[j - 3] + k;
					else
						dp[j] = Integer.MAX_VALUE;
					dp[j] = Math.min(dp[j], Math.min(dp[j - 2] + jump[j - 2][1], dp[j - 1] + jump[j - 1][0]));
				}

				answer = Math.min(answer, dp[n]);
			}
		} else
			answer = dp[n];

		System.out.println(answer);
	}
}
