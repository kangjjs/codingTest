package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int[] asc = new int[n];
        int[] desc = new int[n];
        Arrays.fill(asc, 1);
        Arrays.fill(desc, 1);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (board[j] < board[i] && asc[i] < asc[j] + 1) {
                    asc[i] = asc[j] + 1;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (board[j] < board[i] && desc[i] < desc[j] + 1)
                    desc[i] = desc[j] + 1;
            }
        }
        int[] dp = new int[n];
        int answer = 0;
        for (int i = 0; i < n ; i++) {
            dp[i] = asc[i] + desc[i] - 1;
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);
    }
}
