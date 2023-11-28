package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] s = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);

        int[] dif = new int[n-1];

        for (int i = 0; i < n - 1; i++) {
            dif[i]=s[i+1]-s[i];
        }
        Arrays.sort(dif);

        int ans = 0 ;

        for (int i = 0; i < n - k; i++) {
            ans+=dif[i];
        }

        System.out.println(ans);
    }
}
