package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long dist = y - x;

        if (dist == 0) {
            System.out.println(0);
            return;
        }

        long k = (long) Math.sqrt(dist);

        if (k * k == dist)
            System.out.println(2 * k - 1);
        else if (dist <= k * k + k)
            System.out.println(2 * k);
        else
            System.out.println(2 * k + 1);
    }
}
