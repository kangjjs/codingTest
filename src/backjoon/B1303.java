package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1303 {

	static int n, m;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int w = 0, b = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					if (board[i][j] == 'W') {
						int result = bfs(i, j, 'W');
						w += result * result;
					} else {
						int result = bfs(i, j, 'B');
						b += result * result;
					}
				}
			}
		}

		System.out.println(w + " " + b);
	}

	static int bfs(int x, int y, char ch) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		int count = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == ch) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
					count++;
				}
			}
		}

		return count;
	}
}
