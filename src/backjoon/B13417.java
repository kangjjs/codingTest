package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = "";

            for (int i = 0; i < n; i++) {
                String c = st.nextToken();
                if (i == 0)
                    s += c;
                else {
                    if (s.charAt(0) >= c.charAt(0)) {
                        String str = s;
                        s = c + str;
                    } else {
                        s += c;
                    }
                }
            }

            sb.append(s).append('\n');
        }

        System.out.print(sb);
    }
}
