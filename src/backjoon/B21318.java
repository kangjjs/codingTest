package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21318 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[n + 1];
		sum[1] = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i + 1])
				sum[i + 1] = sum[i] + 1;
			else
				sum[i + 1] = sum[i];
		}

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(sum[end]-sum[start]).append('\n');
		}

		System.out.print(sb);
	}
}
