package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {

	static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
	static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[x][x];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {sx, sy, 0});
			visited[sx][sy] = true;

			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				if (cur[0] == ex && cur[1] == ey) {
					sb.append(cur[2]).append('\n');
					break;
				}

				for (int i = 0; i < 8; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];

					if (nx >= 0 && nx < x && ny >= 0 && ny < x && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny, cur[2] + 1});
					}
				}
			}
		}

		System.out.print(sb);
	}
}