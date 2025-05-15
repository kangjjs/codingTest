package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			int[][] map = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] rowMax = new int[n];
			for (int i = 0; i < n; i++) {
				rowMax[i] = getMaxFromRow(map[i]);
			}

			int answer = getMaxFromRow(rowMax);
			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}

	private static int getMaxFromRow(int[] arr) {
		int n = arr.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return arr[0];
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
		}

		return dp[n - 1];
	}
}
