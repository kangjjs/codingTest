package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1106 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int limit = 1000001;

		int[] dp = new int[101];
		Arrays.fill(dp, limit);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());

			for (int j = people; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - people] + cost);
			}
		}

		int answer = limit;

		for (int i = c; i < dp.length ; i++) {
			answer = Math.min(answer,dp[i]);
		}

		System.out.println(answer);
	}
}
