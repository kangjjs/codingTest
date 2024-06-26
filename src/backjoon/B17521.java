package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (cnt == 0 && arr[i] < arr[i + 1]) {
                cnt = W / arr[i];
                W = W % arr[i];
            }

            if (arr[i] > arr[i + 1]) {
                W += cnt * arr[i];
                cnt = 0;
            }
        }

        W += cnt*arr[n-1];

        System.out.println(W);
    }
}
