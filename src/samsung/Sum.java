package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append("#").append(num).append(" ");
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < 100; i++) {
                int sum1 = Arrays.stream(arr[i]).sum();
                int sum2 = 0;
                for (int j = 0; j < 100; j++) {
                    sum2 += arr[j][i];
                }

                ans = Math.max(sum1, ans);
                ans = Math.max(sum2, ans);
            }

            int sum3 = 0;
            for (int i = 0; i < 100; i++) {
                sum3 += arr[i][i];
            }
            ans = Math.max(ans, sum3);

            int sum4 = 0;
            for (int i = 0; i < 100; i++) {
                sum4 += arr[i][99 - i];
            }

            ans = Math.max(ans, sum4);

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
