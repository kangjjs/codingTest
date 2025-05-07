package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17391 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0});
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int jump = map[cur[0]][cur[1]];

			if (cur[0] == n - 1 && cur[1] == m - 1) {
				System.out.print(cur[2]);
				return;
			}

			for (int i = 1; i <= jump; i++) {
				int nx = cur[0];
				int ny = cur[1] + i;

				if (ny < m && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}

			for (int i = 1; i <= jump; i++) {
				int nx = cur[0] + i;
				int ny = cur[1];

				if (nx < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}
	}
}
