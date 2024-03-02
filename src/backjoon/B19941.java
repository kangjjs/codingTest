package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] c = br.readLine().toCharArray();
        boolean[] b = new boolean[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (c[i] == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
                for (int j = start; j <= end; j++) {
                    if (c[j] == 'H' && !b[j]) {
                        b[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}