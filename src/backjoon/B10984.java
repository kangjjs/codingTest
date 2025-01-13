package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int c = 0;
            double g = 0.0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int credit = Integer.parseInt(st.nextToken());
                double grade = Double.parseDouble(st.nextToken());
                c += credit;
                g += (credit * grade);
            }
            g = Math.ceil(g / c * 10) / 10.0;
            sb.append(c).append(" ").append(g).append('\n');
        }

        System.out.print(sb);
    }
}
