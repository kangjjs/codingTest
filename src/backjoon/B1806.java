package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            while (sum >= s) {
                ans = Math.min(ans, rt - lt + 1);
                sum -= arr[lt++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}