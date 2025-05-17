package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683 {

	static int n, m, answer;
	static int[][] board;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Cctv> list;

	static class Cctv {
		int x, y, value;

		public Cctv(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		list = new ArrayList<>();
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] >= 1 && board[i][j] <= 5)
					list.add(new Cctv(i, j, board[i][j]));
			}
		}

		dfs(0, board);
		System.out.println(answer);
	}

	static void dfs(int l, int[][] map) {
		if (l == list.size()) {
			answer = Math.min(answer, count(map));
			return;
		}

		Cctv cur = list.get(l);
		int[][] copy;

		for (int[] dir : getDirections(cur.value)) {
			copy = copyMap(map);
			for (int d : dir) {
				watch(cur.x, cur.y, d, copy);
			}
			dfs(l + 1, copy);
		}
	}

	static void watch(int x, int y, int d, int[][] map) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += dx[d];
			ny += dy[d];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 6)
				break;
			if (map[nx][ny] == 0)
				map[nx][ny] = -1;
		}
	}

	static List<int[]> getDirections(int value) {
		List<int[]> result = new ArrayList<>();
		switch (value) {
			case 1:
				for (int i = 0; i < 4; i++) {
					result.add(new int[] {i});
				}
				break;
			case 2:
				result.add(new int[] {1, 3});
				result.add(new int[] {0, 2});
				break;
			case 3:
				result.add(new int[] {0, 1});
				result.add(new int[] {1, 2});
				result.add(new int[] {2, 3});
				result.add(new int[] {3, 0});
				break;
			case 4:
				result.add(new int[] {0, 1, 2});
				result.add(new int[] {1, 2, 3});
				result.add(new int[] {2, 3, 0});
				result.add(new int[] {3, 0, 1});
				break;
			case 5:
				result.add(new int[] {0, 1, 2, 3});
				break;
		}

		return result;
	}

	static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			newMap[i] = map[i].clone();
		}
		return newMap;
	}

	static int count(int[][] map) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		return count;
	}
}
