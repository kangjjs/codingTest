package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PerfectShuffle {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            int x = n / 2;
            if (n % 2 == 0) {
                for (int i = 0; i < x; i++) {
                    sb.append(arr[i]).append(" ").append(arr[x + i]).append(" ");
                }
            } else {
                int y = x + 1;
                for (int i = 0; i < x; i++) {
                    sb.append(arr[i]).append(" ").append(arr[y + i]).append(" ");
                }
                sb.append(arr[x]).append(" ");
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}
