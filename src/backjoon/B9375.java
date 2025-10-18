package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());

            HashMap<String, Integer> hm = new HashMap<>();

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                hm.put(b, hm.getOrDefault(b, 0) + 1);
            }

            int answer = 1;
            for (int x : hm.values()) {
                answer *= (x + 1);
            }

            sb.append(answer-1).append('\n');
        }

        System.out.print(sb);
    }
}
