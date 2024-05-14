package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        StringBuilder sb = new StringBuilder();
        int num = 1;
        while (t-- > 0) {
            sb.append("#").append(num++).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
                if (arr[i] > max) {
                    ans += arr[i] - max;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
