package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int result = Math.abs(n - 100);

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean flag = false;

            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int min = Math.abs(n - i) + num.length();
                result = Math.min(result, min);
            }
        }
        System.out.println(result);
    }
}
