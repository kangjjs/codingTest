package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		int[][] J = new int[m + 1][n + 1];
		int[][] I = new int[m + 1][n + 1];
		int[][] O = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				char c = str.charAt(j - 1);

				J[i][j] = J[i][j - 1] + J[i - 1][j] - J[i - 1][j - 1];
				I[i][j] = I[i][j - 1] + I[i - 1][j] - I[i - 1][j - 1];
				O[i][j] = O[i][j - 1] + O[i - 1][j] - O[i - 1][j - 1];

				if (c == 'J')
					J[i][j]++;
				else if (c == 'I')
					I[i][j]++;
				else if (c == 'O')
					O[i][j]++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int jCount = J[c][d] - J[a - 1][d] - J[c][b - 1] + J[a - 1][b - 1];
			int iCount = I[c][d] - I[a - 1][d] - I[c][b - 1] + I[a - 1][b - 1];
			int oCount = O[c][d] - O[a - 1][d] - O[c][b - 1] + O[a - 1][b - 1];
			sb.append(jCount).append(" ").append(oCount).append(" ").append(iCount).append("\n");
		}

		System.out.print(sb);
	}
}