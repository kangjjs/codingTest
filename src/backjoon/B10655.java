package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10655 {

    static int n, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        for (int i = 1; i < n; i++) {
            total += dist(arr[i-1],arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int skip = total
                    - dist(arr[i-1], arr[i])
                    - dist(arr[i], arr[i+1])
                    + dist(arr[i-1], arr[i+1]);
            ans = Math.min(ans, skip);
        }

        System.out.println(ans);
    }

    static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
