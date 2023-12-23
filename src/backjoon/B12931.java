package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int sum = Arrays.stream(B).sum();
        int ans = 0;
        while (sum != 0) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (B[i] % 2 == 1) {
                    B[i]--;
                    num++;
                }
            }

            if (num > 0) {
                sum -= num;
                ans += num;
            } else {
                for (int i = 0; i < N; i++) {
                    B[i] /= 2;
                }
                sum /= 2;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
