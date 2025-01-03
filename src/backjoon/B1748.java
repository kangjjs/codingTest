package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int ans = 0;
        int length = 10;

        for (int i = 1; i <= n; i++) {
            if (i == length) {
                cnt++;
                length = length * 10;
            }
            ans += cnt;
        }
        System.out.print(ans);
    }
}
