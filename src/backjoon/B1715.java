package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        int sum;

        if(N==1) {
            System.out.println(0);
            return;
        }
        while (true) {
            int x = pq.poll();
            int y = pq.poll();

            sum = x+y;
            ans+=sum;

            if(pq.isEmpty())
                break;
            pq.offer(sum);
        }

        System.out.println(ans);
    }
}