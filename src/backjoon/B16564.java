package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long lt = arr[0];
        long rt = arr[N - 1] + K;
        long ans = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;
            for (int l : arr) {
                if (mid > l)
                    sum += mid - l;
            }

            if (sum <= K) {
                ans = mid;
                lt = mid + 1;
            } else
                rt = mid - 1;
        }

        System.out.println(ans);
    }
}
