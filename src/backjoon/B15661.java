package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661 {

    static int n, ans;
    static int[][] board;
    static boolean[] pick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        pick = new boolean[n];
        pick[0] = true;
        dfs(1, 1);

        System.out.println(ans);
    }

    static void dfs(int idx, int cnt) {
        if (ans == 0)
            return;
        if (idx == n) {
            if (cnt > 0 && cnt < n) {
                ans = Math.min(ans,diff());
            }

            return;
        }

        pick[idx] = true;
        dfs(idx+1,cnt+1);

        pick[idx] = false;
        dfs(idx+1,cnt);
    }

    static int diff() {
        int aSum = 0, bSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = board[i][j] + board[j][i];

                if (pick[i] && pick[j])
                    aSum += sum;
                else if (!pick[i] && !pick[j])
                    bSum += sum;
            }
        }

        return Math.abs(aSum-bSum);
    }
}
