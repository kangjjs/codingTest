package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Grocery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (n-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            while (st.hasMoreTokens()) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while (m-- > 0) {
                Long x = pq.poll();
                sb.append(x).append(" ");
                Long y = x / 3 + x;
                pq.remove(y);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}