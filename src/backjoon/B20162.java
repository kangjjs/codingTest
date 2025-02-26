package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long[] dp = new long[n];

		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]){
					dp[i] = Math.max(dp[i],dp[j]+arr[i]);
				}
			}
		}

		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans,dp[i]);
		}

		System.out.println(ans);
	}
}