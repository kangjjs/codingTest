package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3067 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] coins = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			int[] dp = new int[m + 1];

			dp[0] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = coins[i]; j <= m; j++) {
					dp[j] += dp[j-coins[i]];
				}
			}

			sb.append(dp[m]).append('\n');
		}

		System.out.print(sb);
	}
}
