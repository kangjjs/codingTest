package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = n - 1, rt = n;
        int ans = Integer.MAX_VALUE;

        while (lt >= 0) {
            ans = Math.min(arr[lt]+arr[rt],ans);
            lt--;
            rt++;
        }

        System.out.println(ans);
    }
}
