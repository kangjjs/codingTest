package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int cnt = 0;
        PriorityQueue<Long> pq;

        while (cnt < T) {
            cnt++;

            int K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long ans = 0;
            long sum;

            while (true) {
                long x = pq.poll();
                long y = pq.poll();

                sum = x + y;
                ans += sum;

                if(pq.isEmpty()){
                    break;
                }

                pq.offer(sum);
            }

            System.out.println(ans);
        }
    }
}
