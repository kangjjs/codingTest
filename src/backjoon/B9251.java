package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = s1.length();
        int len2 = s2.length();
        char[] c1 = new char[len1+1];
        char[] c2 = new char[len2+1];
        for (int i = 1; i <= len1; i++) {
            c1[i] = s1.charAt(i-1);
        }

        for (int i = 1; i <= len2; i++) {
            c2[i] = s2.charAt(i-1);
        }

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(c2[j]==c1[i]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
    }
}
