package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] p = new Integer[n];

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(p, Collections.reverseOrder());
        int order = 1;
        long ans = 0;

        for (int i = 0; i < n; i++, order++) {
            if(p[i]-(order-1)<0)
                continue;
            ans += p[i] - (order - 1);
        }

        System.out.println(ans);
    }
}
