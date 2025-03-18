package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		int[] degree = new int[n + 1];
		int[] ans = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			degree[y]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				q.add(i);
				ans[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int y : graph.get(cur)) {
				degree[y]--;
				if (degree[y] == 0) {
					q.add(y);
					ans[y] = ans[cur] + 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}