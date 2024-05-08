package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String first = br.readLine();
        int ans = 0;

        for (int i = 1; i < n; i++) {
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];

            for (int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if (word[str.charAt(j)- 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            if (first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {
                ans++;
            } else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {
                ans++;
            } else if (first.length() == str.length() + 1 && str.length() == cnt) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
