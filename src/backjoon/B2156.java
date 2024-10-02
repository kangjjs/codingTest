package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        for (int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = drink[0];

        for(int i=1;i<n;i++){
            if(i==1){
                dp[1] = drink[0] + drink[1];
            }else if(i== 2){
                dp[2] = Math.max(dp[1],Math.max(drink[0]+drink[2],drink[1]+drink[2]));
            }else{
                dp[i] = Math.max(dp[i-1],Math.max(dp[i-3]+drink[i-1]+drink[i],dp[i-2]+drink[i]));
            }
        }

        System.out.println(dp[n-1]);
    }
}
