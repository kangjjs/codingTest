package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			long[] temp = new long[m];

			for (int j = i; j < n; j++) {
				for (int k = 0; k < m; k++) {
					temp[k] += arr[j][k];
				}

				long cur = temp[0];
				long max = temp[0];

				for (int k = 1; k < m; k++) {
					max = Math.max(temp[k],max+temp[k]);
					cur = Math.max(cur,max);
				}

				ans = Math.max(ans,cur);
			}
		}

		System.out.println(ans);
	}
}
