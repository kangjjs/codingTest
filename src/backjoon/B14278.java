package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14278 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] time = new int[n + 1];
		int[] point = new int[n + 1];
		int[] dp = new int[t + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			point[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = t; j >= time[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - time[i]] + point[i]);
			}
		}

		System.out.println(dp[t]);
	}
}
