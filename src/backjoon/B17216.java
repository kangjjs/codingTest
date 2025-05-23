package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}

		int ans = dp[0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			ans = Math.max(ans,dp[i]);
		}

		System.out.println(ans);
	}
}
