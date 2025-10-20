package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String word = br.readLine();

            sb.append(nextWord(word)).append('\n');
        }

        System.out.print(sb);
    }

    private static String nextWord(String s) {
        char[] c = s.toCharArray();
        int l = s.length();

        int idx1 = -1;

        for (int i = l - 1; i > 0; i--) {
            if (c[i - 1] < c[i]) {
                idx1 = i - 1;
                break;
            }
        }

        if (idx1 == -1) {
            return s;
        }

        int idx2 = -1;
        for (int i = l - 1; i > idx1; i--) {
            if (c[idx1] < c[i]) {
                idx2 = i;
                break;
            }
        }

        char tmp = c[idx1];
        c[idx1] = c[idx2];
        c[idx2] = tmp;

        Arrays.sort(c, idx1 + 1, l);

        return new String(c);
    }
}
