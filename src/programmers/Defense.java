package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Defense {
    public int solution(int n, int k, int[] enemy) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : enemy) {
            n -= x;
            pq.offer(x);
            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            ans++;
        }

        return ans;
    }
}
