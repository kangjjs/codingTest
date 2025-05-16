package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1743 {

	static int n, m;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					answer = Math.max(answer,bfs(map,i,j));
				}
			}
		}

		System.out.println(answer);
	}

	static int bfs(int[][] map, int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int count = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx >= 0 && nx <= n && ny >= 0 && ny <= m && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
					count++;
				}
			}
		}

		return count;
	}
}
