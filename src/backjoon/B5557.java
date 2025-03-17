package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5557 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[n - 1][21];
		dp[0][arr[0]] = 1;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] > 0) {
					int p = j + arr[i];
					int m = j - arr[i];

					if (p <= 20)
						dp[i][p] += dp[i - 1][j];
					if (m >= 0)
						dp[i][m] += dp[i - 1][j];
				}
			}
		}

		System.out.print(dp[n-2][arr[n-1]]);
	}
}
