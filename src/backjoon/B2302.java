package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int ans = 1;

		int before = 0;
		for (int i = 0; i < m; i++) {
			int vip = Integer.parseInt(br.readLine());
			ans *= dp[vip - before - 1];
			before = vip;
		}

		ans *= dp[n - before];

		System.out.println(ans);
	}
}
