package backjoon;

import java.io.*;
import java.util.*;

public class B25947 {
    static int n, b, a;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int left = 0, right = n;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (discount(mid)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean discount(int cnt) {
        long sum = 0;
        int dis = Math.min(cnt, a);
        for (int i = 0; i < cnt - dis; i++) {
            sum += arr[i];
        }

        for (int i = cnt - dis; i < cnt; i++) {
            sum += arr[i] / 2;
        }

        return sum <= b;
    }
}
