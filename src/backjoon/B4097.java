package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4097 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			long ans = arr[0];
			long sum = arr[0];

			for (int i = 1; i < n; i++) {
				sum = Math.max(arr[i], sum + arr[i]);
				ans = Math.max(ans, sum);
			}

			sb.append(ans).append('\n');
		}

		System.out.print(sb);
	}
}
