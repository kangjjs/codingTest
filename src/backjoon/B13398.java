package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (n == 1) {
			System.out.println(arr[0]);
			return;
		}

		int[] dp = new int[n];
		int[] dpDel = new int[n];

		dp[0] = arr[0];
		dpDel[0] = 0;

		int max = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			dpDel[i] = Math.max(dp[i - 1], dpDel[i - 1] + arr[i]);
			max = Math.max(max,Math.max(dp[i],dpDel[i]));
		}

		System.out.println(max);
	}
}
