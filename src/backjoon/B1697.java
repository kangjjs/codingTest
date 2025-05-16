package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] visited = new int[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == k) {
				System.out.println(visited[cur] - 1);
				return;
			}

			for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
				if (next >= 0 && next < 100001 && visited[next] == 0) {
					visited[next] = visited[cur] + 1;
					queue.add(next);
				}
			}
		}
	}
}
