package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			long[] sum = new long[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i + 1] = arr[i] + sum[i];
			}

			long max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					long s = sum[j + 1] - sum[i];
					max = Math.max(max, s);
				}
			}

			sb.append(max).append('\n');
		}
		System.out.print(sb);
	}
}
