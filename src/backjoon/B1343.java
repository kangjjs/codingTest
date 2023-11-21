package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] s = str.split("\\.");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            String x = s[i];

            if (x.length() % 2 != 0) {
                sb = new StringBuilder("-1");
                break;
            } else if (x.length() % 4 == 0) {
                sb.append("AAAA".repeat(x.length() / 4));
            } else {
                sb.append("AAAA".repeat(x.length() / 4));
                sb.append("BB");
            }

            if (i != s.length - 1) {
                sb.append(".");
            }
        }

        if (!sb.toString().equals("-1")) {
            sb.append(".".repeat(str.length() - sb.toString().length()));
        }

        System.out.println(sb);
    }
}
