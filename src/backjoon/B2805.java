package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int lt = 0;
        int rt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(rt, arr[i]);
        }

        int mid = (lt + rt) / 2;

        while (lt <= rt) {
            long sum = 0;

            for (int x : arr) {
                if (x > mid)
                    sum += x - mid;
            }

            if (sum < M)
                rt = mid - 1;
            else
                lt = mid + 1;
            mid = (lt + rt) / 2;
        }

        System.out.println(mid);
    }
}
