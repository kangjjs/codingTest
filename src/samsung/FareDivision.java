package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class FareDivision {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (t-- > 0) {
            sb.append("#").append(num++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i <= n - m; i++) {
                ans = Math.min(ans, arr[i + m - 1] - arr[i]);
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
