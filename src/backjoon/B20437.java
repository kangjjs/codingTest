package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int i = 0; i < w.length() - 1; i++) {
                if (alpha[w.charAt(i) - 'a'] < k)
                    continue;
                int count = 1;
                for (int j = i + 1; j < w.length(); j++) {
                    if (w.charAt(i) == w.charAt(j))
                        count++;
                    if (count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max,j-i+1);
                        break;
                    }
                }
            }

            if(min == Integer.MAX_VALUE || max==-1)
                System.out.println("-1");
            else
                System.out.println(min+" "+max);
        }
    }
}
