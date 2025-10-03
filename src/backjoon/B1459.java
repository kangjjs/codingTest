package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long max = Math.max(x, y);
        long min = Math.min(x, y);

        long cost1 = (x + y) * w;
        long cost2 = min * s + (max - min) * w;

        long cost3;

        if ((x + y) % 2 == 0)
            cost3 = max * s;
        else
            cost3 = (max - 1) * s + w;

        long ans = Math.min(cost1,Math.min(cost2,cost3));
        System.out.println(ans);
    }
}