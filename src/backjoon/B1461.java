package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0)
                plus.add(x);
            else
                minus.add(x);
        }

        int ans = 0,max=0;
        while (!plus.isEmpty()) {
            int x = plus.poll();
            for (int i = 1; i < m; i++) {
                if (!plus.isEmpty()) {
                    plus.poll();
                }
            }

            max = Math.max(x,max);
            ans += x *2;
        }

        while (!minus.isEmpty()) {
            int x = Math.abs(minus.poll());
            for (int i = 1; i < m; i++) {
                if (!minus.isEmpty()) {
                    minus.poll();
                }
            }

            max = Math.max(x,max);
            ans += x * 2;
        }

        System.out.print(ans-max);
    }
}
