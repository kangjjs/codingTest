package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M + 1];

			dp[0] = 1;

			for (int coin : coins) {
				for (int j = coin; j <= M; j++) {
					dp[j] += dp[j - coin];
				}
			}

			sb.append(dp[M]).append("\n");
		}

		System.out.print(sb);
	}
}
