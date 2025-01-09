package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            String ans = "";

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());
                if (cnt > max) {
                    max = cnt;
                    ans = name;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
