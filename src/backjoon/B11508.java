package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] price = new Integer[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(price, Collections.reverseOrder());
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (i % 3 == 2)
                continue;
            ans += price[i];
        }

        System.out.println(ans);
    }
}
