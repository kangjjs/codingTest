package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        int num = 9901;

        Arrays.fill(dp[1],1);
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%num;
            dp[i][1] = (dp[i-1][2]+dp[i-1][0])%num;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%num;
        }

        int ans = Arrays.stream(dp[N]).sum()%num;
        System.out.println(ans);
    }
}
