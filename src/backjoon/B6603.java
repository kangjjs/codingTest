package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B6603 {

	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;

	static void dfs(int l, int s, int n) {
		if (l == 6) {
			for (int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = s; i <= n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list.add(arr[i]);
					dfs(l + 1, i, n);
					visited[i] = false;
					list.remove(Integer.valueOf(arr[i]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			arr = new int[n+1];
			visited = new boolean[n+1];
			list = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 1, n);

			System.out.println();
		}
	}
}
