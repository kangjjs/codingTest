package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[] dp;
		for (int i = 1; i <= 100000; i++) {
			dp = new int[d + 1];
			boolean flag = false;
			dp[1] = i;
			for (int j = i; j <= 100000; j++) {
				dp[2] = j;
				for (int l = 3; l <= d; l++) {
					dp[l] = dp[l - 1] + dp[l - 2];
				}

				if (dp[d] == k) {
					flag = true;
					break;
				}
			}

			if (flag) {
				sb.append(dp[1]).append('\n').append(dp[2]);
				break;
			}
		}

		System.out.print(sb);
	}
}

