package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1922 {

	static class Edge implements Comparable<Edge> {

		int from, to, value;

		public Edge(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, value));
		}

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int answer = 0;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (find(e.from) != find(e.to)) {
				union(e.from,e.to);
				answer+=e.value;
			}
		}

		System.out.println(answer);
	}

	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}
