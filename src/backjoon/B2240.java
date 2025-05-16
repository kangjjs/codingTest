package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] tree = new int[t + 1];
		for (int i = 1; i <= t; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[t + 1][w + 1];

		for (int i = 1; i <= t; i++) {
			for (int j = 0; j <= w; j++) {
				int cur = (j % 2) == 0 ? 1 : 2;

				if (tree[i] == cur) {
					if (j == 0) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
					}
				}else{
					if (j == 0) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= w; i++) {
			answer = Math.max(answer, dp[t][i]);
		}

		System.out.println(answer);
	}
}
