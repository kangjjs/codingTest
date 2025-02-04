package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B23843 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq1.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < m && !pq1.isEmpty(); i++) {
			pq2.add(pq1.poll());
		}

		int ans = 0;

		while (!pq2.isEmpty()) {
			int cur = pq2.poll();
			ans = cur;

			if (!pq1.isEmpty()) {
				pq2.add(cur + pq1.poll());
			}
		}

		System.out.println(ans);
	}
}
