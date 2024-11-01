package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        String[] ans = new String[2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                int length = Math.min(arr[i].length(), arr[j].length());
                for (int k = 0; k < length; k++) {
                    if (arr[i].charAt(k) == arr[j].charAt(k))
                        cnt++;
                    else
                        break;
                }

                if (cnt > max) {
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    max = cnt;
                }
            }
        }

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
