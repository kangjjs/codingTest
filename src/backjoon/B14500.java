package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {

	static int n, m, max;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = 0;
		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
				getSpecial(i, j);
			}
		}

		System.out.println(max);
	}

	static void getSpecial(int x, int y) {
		if (x >= 0 && x + 1 < n && y + 2 < m)
			max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1]);
		if (x >= 1 && x < n && y + 2 < m)
			max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x - 1][y + 1]);
		if (x + 2 < n && y + 1 < m)
			max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1]);
		if (x + 2 < n && y >= 1)
			max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y - 1]);
	}

	static void dfs(int x, int y, int sum, int l) {
		if (l == 4) {
			max = Math.max(max, sum);
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, sum + arr[nx][ny], l + 1);
					visited[nx][ny] = false;
				}
			}
		}
	}
}