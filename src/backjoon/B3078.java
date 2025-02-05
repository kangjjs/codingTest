package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3078 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer>[] q = new Queue[21];
		for (int i = 0; i <= 20; i++) {
			q[i] = new LinkedList<>();
		}

		long ans = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int l = str.length();

			while (!q[l].isEmpty() && i - q[l].peek() > k) {
				q[l].poll();
			}

			ans += q[l].size();
			q[l].add(i);
		}

		System.out.println(ans);
	}
}