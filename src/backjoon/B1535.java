package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1535 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] hp = new int[n+1];
		int[] happy = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][100];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 100; j++) {
				if (j >= hp[i]) {
					dp[i][j] = Math.max(dp[i - 1][j - hp[i]] + happy[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][99]);
	}
}
