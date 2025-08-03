package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[21];
        dp[1]=1; dp[2]=2; dp[3]=4; dp[4]=7;

        for(int i=5; i<=n; i++){
            dp[i] = dp[i-1] * 2;
            if(i % 2 == 0) {
                dp[i] -= dp[i-4] + dp[i-5];
            }
        }

        System.out.println(dp[n]);
    }
}
