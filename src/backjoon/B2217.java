package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans=Math.max(ans,ropes[i]*(i+1));
        }

        System.out.println(ans);
    }
}
