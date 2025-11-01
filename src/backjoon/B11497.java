package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11497 {

    static int N;
    static int[] arr, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int[] res = new int[N];
            int left = 0, right = N - 1;

            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) res[left++] = arr[i];
                else res[right--] = arr[i];
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                int diff = Math.abs(res[i] - res[(i + 1) % N]);
                ans = Math.max(diff, ans);
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
