package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        int maxX = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = w;
            maxX = Math.max(maxX, x);
        }

        int winodw = k * 2 + 1;

        long sum = 0;
        long ans;

        int end = Math.min(maxX, winodw - 1);

        for (int i = 0; i <= end; i++) {
            sum += arr[i];
        }

        ans = sum;

        for (int i = 1; i + winodw - 1 <= maxX; i++) {
            sum-=arr[i-1];
            sum+=arr[i+winodw-1];
            ans = Math.max(sum,ans);
        }

        System.out.println(ans);
    }
}
