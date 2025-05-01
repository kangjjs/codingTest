package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int n = str.length();

		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			int one = str.charAt(i - 1) - '0';
			if (1 <= one && one <= 9) {
				dp[i] += dp[i - 1];
			}

			if (i >= 2) {
				int two = Integer.parseInt(str.substring(i - 2, i));
				if (10 <= two && two <= 34) {
					dp[i] += dp[i - 2];
				}
			}
		}

		System.out.print(dp[n]);
	}
}
