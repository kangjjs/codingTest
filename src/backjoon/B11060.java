package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11060 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] step = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			step[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;

		for (int i = 1; i <= n; i++) {
			if(dp[i]==Integer.MAX_VALUE)
				continue;
			for (int j = 1; j <= step[i]; j++) {
				if (i + j <= n) {
					dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
				}
			}
		}

		System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
	}
}