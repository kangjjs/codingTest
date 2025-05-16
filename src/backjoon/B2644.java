package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			graph.get(l).add(k);
			graph.get(k).add(l);
		}

		boolean[] visited = new boolean[n + 1];
		visited[x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int p = cur[0];
			int d = cur[1];

			if (p == y) {
				System.out.println(d);
				return;
			}

			for (int next : graph.get(p)) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(new int[] {next, d + 1});
				}
			}
		}

		System.out.println(-1);
	}
}
