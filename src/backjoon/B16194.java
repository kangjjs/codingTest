package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16194 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] price = new int[n + 1];
		int[] dp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + price[j]);
			}
		}

		System.out.println(dp[n]);
	}
}