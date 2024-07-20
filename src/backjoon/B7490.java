package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7490 {

    static StringBuilder sb;

    static void dfs(int n, int k, int num, int sign, int s, String str) {
        if (n == k) {
            s = s + (num * sign);
            if (s == 0) {
                sb.append(str).append('\n');
            }
            return;
        }
        dfs(n, k + 1, 10 * num + (k + 1), sign, s, str + " " + (k + 1));
        dfs(n, k + 1, k + 1, 1, s + (num * sign), str + "+" + (k + 1));
        dfs(n, k + 1, k + 1, -1, s + (num * sign), str + "-" + (k + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            dfs(k, 1, 1, 1, 0, "1");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
